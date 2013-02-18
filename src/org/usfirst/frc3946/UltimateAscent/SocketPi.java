/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3946.UltimateAscent;

import com.sun.squawk.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

/**
 *
 * @author Gustave Michel
 * A TCP Socket Client
 */
public class SocketPi {
    //Defaults
        public static final String defaultIp = "10.39.46.12";
        public static final String defaultPort = "10000";
        public static final int defaultBufferSize = 64;
        public static final char defaultDelimiter = ',';
    //Defaults
    
    private String ip;
    private String port;
    private String url;
    private int bufferSize;
    private char delimiter;
    private boolean beenConnected = false;
    private boolean connected;
    
    private SocketConnection client;
    private InputStream is;
    private OutputStream os;
    
    public static byte[] receiveData;
    private String rawData;
    
    /**
     * Constructor using Defaults
     */
    public SocketPi() {
        this(defaultIp, defaultPort, defaultBufferSize, defaultDelimiter);
    }
    
    /**
     * Constructor using custom
     * @param ip Address of Server "xxx.xxx.xxx.xxx"
     * @param port of Server "XXXXX"
     */
    public SocketPi(String ip, String port, int bufferSize, char delimiter) {
        try {
            connect(ip, port, bufferSize, delimiter);
        } catch (IOException ex) {
            System.out.println("Failed to Connect, SocketPi Constructor");
        }
    }
    
    /**
     * Connect using last settings
     */
    public void connect() throws IOException {
        if(beenConnected == false) {
            connect(defaultIp, defaultPort, defaultBufferSize, defaultDelimiter);
        } else {
            this.connect(ip, port, bufferSize, delimiter);
        }
    }
    /**
     * Connect using custom settings
     * @param ip Address of Server "xxx.xxx.xxx.xxx"
     * @param port of Server "XXXXX"
     */
    public void connect(String ip, String port, int bufferSize, char delimiter) throws IOException {
        this.ip = ip;
        this.port = port;
        this.bufferSize = bufferSize;
        this.delimiter = delimiter;
        beenConnected = true;
        url = "socket://" + ip + ":" + port; //Store URL of Connection
        System.out.println("Connecting to PI...");
        client = (SocketConnection) Connector.open(url, Connector.READ_WRITE, true); //Setup input and output through client SocketConnection
        try{            
            is = client.openInputStream();
            os = client.openOutputStream();
            if(true) {
                System.out.println("Connected to: "+client.getAddress() + ":" + client.getPort());
            }
            connected = true;
        }
        catch (Exception ex){
             connected = false;
        }
        
        
    }
    
    /**
     * Closes socket connection
     */
    public void disconnect() throws IOException {
        is.close();
        os.close();
        client.close();
        System.out.println("Disconnected");
        connected = false;
        
    }
    
    /**
     * Returns Status of Socket connection
     * @return if 
     */
    public boolean isConnected() {
        
        //need to actually test the connection 
        //to figure out if we're connected or not
        try{
            os.write('\n'); //request Data
        }
        catch(Exception ex){
            connected = false;
        }
        
        return connected;
    }
    
    public String getRawData() throws IOException {
        byte[] input;
        
        if (connected) {
            os.write('G'); //request Data
            System.out.println("Requested Data");
            
            if(is.available() <= bufferSize) {
                input = new byte[is.available()]; //storage space sized to fit!
                receiveData = new byte[is.available()];
                is.read(input);
                for(int i = 0; (i < input.length) && (input != null); i++) {
                    receiveData[i] = input[i]; //transfer input to full size storage
                }
            } else {
                System.out.println("PI OVERFLOW");
                is.skip(is.available()); //reset if more is stored than buffer
                return null;
            }
            
            rawData = ""; //String to transfer received data to
            System.out.println("Raw Data: "+receiveData.length);
            for (int i = 0; i < receiveData.length; i++) {
                rawData += (char) receiveData[i]; //Cast bytes to chars and concatinate them to the String
            }
            System.out.println(rawData);
            return rawData;
        } else {
            connect();
            return null;
        }
    }
    
    /**
     * Separates input String into many Strings based on the delimiter given
     * @param input String to be tokenized
     * @return String Array of Tokenized Input String
     */
    public String[] tokenizeData(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, String.valueOf(delimiter));
        String output[] = new String[tokenizer.countTokens()];
        
        for(int i = 0; i < output.length; i++) {
            output[i] = tokenizer.nextToken();
        }
        return output;
    }
    
    public Vector parseData(String[] input) {
        System.out.println("Parse Input: "+input.length);
        Vector output = new Vector(input.length);
        for(int i = 0; i < input.length; i++) {
            System.out.print(i+" ");
            if(isNumeric(input[i])) {
                output.setElementAt(new Integer(Integer.parseInt(input[i])), i); //Convert to Int if possible
            } else {
                //TODO Check for single character and convert to Character
                output.setElementAt(input[i], i); //Store as is
            }
        }
        return output;
    }
    
    public boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.lipermi.exception.LipeRMIException;

/**
 *
 * @author senura
 */
public class ServerConnection {

    /**
     * @param args the command line arguments
     */
    
    
    
    private static TestServer testServer=null;
    private static String GETURL="";
    
    public static boolean start(){
        try {
            testServer = new TestServer();
            return true;
        } catch (LipeRMIException | IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    }
    
    
    public static boolean closeTheConnection() {
        return testServer.closeConnection();
    }
    
    public static String getDDOSURL(){
    return GETURL;
    }
    public static void setDDOSURL(String url){
     GETURL=url;
        System.out.println("DDOS url set");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.io.IOException;
import net.sf.lipermi.exception.LipeRMIException;

/**
 *
 * @author senura
 */
public class ServerConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LipeRMIException, IOException {
        // TODO code application logic here
        
         TestServer testServer = new TestServer();
         testServer.TestServer();
        
    }
    
}

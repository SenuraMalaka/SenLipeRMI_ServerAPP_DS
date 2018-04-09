/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.io.IOException;
import java.net.Socket;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.net.Server;

/**
 *
 * @author senura
 */
public class TestServer {
    
    
    public void TestServer () throws LipeRMIException, IOException {

        System.out.println("cons called");
     
            CallHandler callHandler = new CallHandler(); 


            TestService interfaceImplementation;
          interfaceImplementation = new TestServiceImpl();

          callHandler.registerGlobal(TestService.class,
            interfaceImplementation);

          Server server = new Server();
          int thePortIWantToBind = 58882;

          server.bind(thePortIWantToBind, callHandler);
         
          
          
           server.addServerListener(new IServerListener() {

            @Override
            public void clientDisconnected(Socket socket) {
                System.out.println("Client Disconnected: " + socket.getInetAddress());
            }

            @Override
            public void clientConnected(Socket socket) {
                System.out.println("Client Connected: " + socket.getInetAddress());
            }

            
        });
          
          
          System.out.println("server running babe");
        
          
    
    }
    
    
    
    
    
    
}

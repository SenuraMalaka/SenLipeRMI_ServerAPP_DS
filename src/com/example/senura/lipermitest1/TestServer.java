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
    
    
    Server server=null;
    IServerListener serverListener1=null;
    CallHandler callHandler=null;
   TestService interfaceImplementation=null;
    
    public TestServer () throws LipeRMIException, IOException {

        System.out.println(TimeClass.getTime()+"Connection Init");
     
            callHandler = new CallHandler(); 
            

            
          interfaceImplementation = new TestServiceImpl();

        
          callHandler.registerGlobal(TestService.class,
            interfaceImplementation);

          server = new Server();
          int thePortIWantToBind = 58882;

          System.out.println(TimeClass.getTime()+"before bind");
          
          server.bind(thePortIWantToBind, callHandler);
          
          
         System.out.println(TimeClass.getTime()+"Connection Started");
         
         
         
         IServerListener serverListener1=new IServerListener() {

            @Override
            public void clientDisconnected(Socket socket) {
                System.out.println(TimeClass.getTime()+"Bot Disconnected: " + socket.getInetAddress());
            }

            @Override
            public void clientConnected(Socket socket) {
                System.out.println(TimeClass.getTime()+"Bot Connected: " + socket.getInetAddress());
            }
            
        };
          
          
           server.addServerListener(serverListener1);
          
         
          System.out.println(TimeClass.getTime()+"server running..");
        
          
    
    }
    
    public boolean closeConnection(){
        
        boolean isClosingSuccessful=false;
        
        if(!server.equals(null))
        {
            try{
            server.removeServerListener(serverListener1);
        
            server.close();
            callHandler.exportObject(TestService.class, interfaceImplementation);
            
            isClosingSuccessful=true;
            System.out.println(TimeClass.getTime()+"Server Closed");
            }
            catch(Exception ex)
            {
                isClosingSuccessful=false;
                System.out.println(TimeClass.getTime()+"Connection Close Error - "+ex.getMessage());
            }
        }else{
        isClosingSuccessful=false;
        System.out.println(TimeClass.getTime()+"Server Closing Error - No Server");
        }
        
        return isClosingSuccessful;
    
    }
    
   
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import Views.MainMenuUIController;
import java.io.IOException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Client;

/**
 *
 * @author senura
 */
public class ClientControllerCon {
    
    private static TestServiceController remoteObject=null;
    
   
    
    public static boolean start(){
    return setClient();
    }
    
    
       private static boolean setClient(){
        
        boolean isServerCameOnline=false;
           
        CallHandler callHandler = new CallHandler();
        String remoteHost = "192.168.1.4";
        int portWasBinded = 58883;
        
        Client client=null;
       
        try {
            client = new Client(remoteHost, portWasBinded, callHandler);
            isServerCameOnline=true;
        } catch (IOException ex) {
            System.out.println("Controller is not online");
        }
        
        
        if(client!=null){
        remoteObject =
                (TestServiceController) client.getGlobal(TestServiceController.class);
        
        System.out.println(remoteObject.getResponse("hi"));
        
            updateClientStatus(remoteObject.getClientInfo());
      
        }
        return isServerCameOnline;
       }
       
       
       
       public static void updateClientStatus(String status){
           MainMenuUIController.showClientStatus(status);
       }
       
       
       
       
    
    
       
    
}

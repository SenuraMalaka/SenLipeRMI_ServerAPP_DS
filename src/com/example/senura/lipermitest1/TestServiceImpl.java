/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;



/**
 *
 * @author senura
 */
public class TestServiceImpl implements TestService{

    private String URL ="https://httpbin.org/user-agent";
            
    @Override
    public String getResponse(String data) {
        return data+" hey babe.. from Mac :)";
    }

    @Override
    public boolean isHavingHostURL() {
        
       String url = "";
        try {
            url=ServerConnection.getDDOSURL();
        } catch (Exception ex) {
           //System.out.println("error -"+ex.getMessage());
        }

        if(url.equals("")) return false; 
        else return true;
    }

    @Override
    public String getURL() {
        return ServerConnection.getDDOSURL();
    }

    
    
    
    
}

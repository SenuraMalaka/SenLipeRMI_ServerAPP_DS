/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.senura.lipermitest1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author senura
 */
public class URLValidate {
    
    
    
    public static boolean isUrlValid(String urlToRead) {
      URL url;
        
        try {
            url = new URL(urlToRead);
        } catch (MalformedURLException ex) {
            return false;
        }
        
      return true;
   }
    
    
    
}

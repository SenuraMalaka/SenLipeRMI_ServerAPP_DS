/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author senura
 */
public class MainMenuUIController {
    
    
   public static void setTextStatus(String status){
       MainMenu.appendToStatusText(status+"\n");
   }
   
   public static void showClientStatus(String status){
   MainMenu.showClientStatus(status);
   }
    
    
}

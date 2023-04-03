/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Tempalates/Classes/Class.java to edit this template
 */
package ventanas;

import com.formdev.flatlaf.IntelliJTheme;

/**
 *
 * @author Josu
 */
public class Principal {
 
    public static void main(String[] args) {
        try {
            new VentanaLogin();
            IntelliJTheme.setup(Principal.class.getResourceAsStream(
     "/codely_dark.theme.json"));
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
    
}

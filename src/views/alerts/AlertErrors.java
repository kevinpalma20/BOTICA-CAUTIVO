/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.alerts;

import Constans.Enums.ErrorMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author chanchobrujo
 */
public class AlertErrors {

    public static void errorMessageVoidData(){ 
        JOptionPane.showMessageDialog(null, ErrorMessage.DATA_VOID.getValue(), 
                ErrorMessage.ERROR_TITLE.getValue(), JOptionPane.ERROR_MESSAGE); 
    }

    public static void errorMessageSetMessage(String value){ 
        JOptionPane.showMessageDialog(null, value, 
                ErrorMessage.ERROR_TITLE.getValue(), JOptionPane.ERROR_MESSAGE); 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.model;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author samuc
 */
public class Utilitarios {
    
    public void LimpaTela (JPanel container){
        
        Component components[] = container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
                if(component instanceof JComboBox){
                    ((JComboBox)component).setSelectedItem(null);
                        
                        if(component instanceof JTextArea){
                         ((JTextArea)component).setText(null);
                         
                            if (component instanceof JDateChooser) {
                            ((JDateChooser) component).setDate(null);


            }
        }
    }
    
    
        }
    }
}

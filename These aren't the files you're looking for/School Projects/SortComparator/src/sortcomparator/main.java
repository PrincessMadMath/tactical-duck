/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import Interface.SortListener;
import SortAlgorithm.MergeSort;
import View.MainView;

/**
 *
 * @author Mathieu
 */
public class main {
    
    public static void main(String args[]) 
    {
        Controller control = new Controller();
        MainView panel = new MainView(control);
        panel.setVisible(true);
        SortComparator model = new SortComparator(panel);
        control.SetMainView(panel);
        control.SetModel(model);        
    }
}

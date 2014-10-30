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

    public static void main(String args[]) {
         //Normal Code
        
        Controller control = new Controller();
        SortComparator model = new SortComparator();
        
        MainView panel = new MainView(control, model);
        panel.setVisible(true);


        model.addSubscriber(panel.sortView1);

        control.SetMainView(panel);
        control.SetModel(model);
         

        /*Backup Code*/
        /*
        Controller control = new Controller();
        panel = new BackupView(control);
        panel.setVisible(true);
        SortComparator model = new SortComparator(panel);
       // model.InitializeArray(40, 40);
        // model.setupSimulation();
        //control.SetMainView(panel);
        control.SetModel(model);

        // Problème quand le sort est déclenché par le bouton 
        control.RandomizeArray(50, 50);
        //control.setupSimulation();
        Thread t = new Thread(new TestThread(panel));
        t.start();
        */
    }


}

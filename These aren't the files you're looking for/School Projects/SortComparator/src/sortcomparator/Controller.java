/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

/**
 *
 * @author Mathieu
 */
public class Controller{

    public static void main(String args[]) 
    {
        View test = new View();
        SortListener listener = test.sortView1;
        ObservableArray tab = new ObservableArray(100,50);
        //TODO changer le set
        listener.SetObservableArray(tab, 50.0);
        tab.subsribe(listener);
        test.setVisible(true);
        //MergeSort.Sort(tab, 0, tab.Tab.length-1);
        InsertionSort.Sort(tab);
    }

}

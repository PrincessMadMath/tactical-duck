/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import Interface.SortListener;
import SortAlgorithm.MergeSort;
import View.BackupView;
import View.MainView;

/**
 *
 * @author Mathieu
 */
public class SortComparator {
    
    ObservableArray _tab;
    SortListener listener;
    
    int _arrayLenght = 100;
    double _maxValue = 50.0; 

    public SortComparator(MainView view)
    {
        listener = view.sortView1;
        _tab = new ObservableArray();

        _tab.subsribe(listener);
    }
    
    public SortComparator(BackupView view)
    {
        listener = view.sortView1;
        _tab = new ObservableArray();

        _tab.subsribe(listener);
    }
    
    
  
    public void InitializeArray(int length, double maxValue)
    {
        System.out.println(length);
        _tab.Randomize(length, maxValue);
    }
    
    public void setSleepTime(int miliSeconds)
    {
        _tab.setSleepTime(miliSeconds);
    }
    
    public void StartSort()
    {
        System.out.println("Starting Sort!!!!");
        MergeSort.Sort(_tab, 0, _tab.Tab.length-1);
        //InsertionSort.Sort(tab);
    }
    
}

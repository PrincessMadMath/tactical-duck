/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import Interface.ISort;
import sortcomparator.ObservableArray;

/**
 *
 * @author Mathieu
 */
public class QuickSort implements ISort
{

    private static QuickSort _singleton;

    public static QuickSort Instance() {
        if (_singleton == null) {
            _singleton = new QuickSort();
        }

        return _singleton;
    }

    @Override
    public void sort(ObservableArray tab) 
    {
        sort(tab, 0, tab.length-1);
    }
    
    private void sort(ObservableArray tab, int lo, int hi)
    {
        if(lo >= hi)
        {
            return;
        }
        int j = partition(tab, lo, hi);
        //Sort left
        sort(tab, lo, j-1);
        //Sort right
        sort(tab,  j+1, hi);
    }
    
    private int partition(ObservableArray tab, int lo, int hi)
    {
        int middle = lo;
        int i = lo+1;
        int j = hi;
        
        while(true)
        {
            while(tab.Compare(i, middle) <= 0 && i<hi)
            {
                i++;
            }
            while(tab.Compare(j, middle) >= 0 && j>lo)
            {
                j--;
            }
            if(i<j)
            {
                tab.exchange(i, j);
            }
            else
            {
                break;
            }
        }
        tab.exchange(middle, j);
        return j;
    }

    @Override
    public String getName() {
        return "QuickSort";
    }

}

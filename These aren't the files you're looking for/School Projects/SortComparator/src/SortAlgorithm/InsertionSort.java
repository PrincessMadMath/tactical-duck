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
public class InsertionSort implements ISort
{
    private static InsertionSort _singleton;
    
    public static InsertionSort Instance()
    {
        if(_singleton == null)
        {
            _singleton = new InsertionSort();
        }
        
        return _singleton;
    }
    
    
    @Override
    public void sort(ObservableArray tab)
    {
        // Search value for the i th position
        for(int i=0; i< tab.length; i++)
        {
            for(int j = i; j >= 1 && tab.Less(j,j-1); j--)
            {
                tab.exchange(j, j-1);
            }
        }
    }
    
    public static void main(String[] args)
    {
        /*
       Integer[] tableau = {3,2,1,5,4,12, 51, 10, 45, 20, 54, 2, 10};
       InsertionSort.sort(tableau);
       Show(tableau);
                */
    }

    @Override
    public String getName() 
    {
        return "InsertionSort";
    }
    
}
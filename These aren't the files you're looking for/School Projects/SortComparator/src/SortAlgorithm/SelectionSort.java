/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import sortcomparator.ObservableArray;

/**
 *
 * @author Mathieu
 */
public class SelectionSort {

    public static void Sort(ObservableArray tab) {
        
        // Search value for the i th position
        for (int i = 0; i < tab.length; i++) {
            int indexOfNextSmallest = i;
            // Search for the next smallest value
            for (int j = i + 1; j < tab.length; j++) {
                if (tab.Less(j, indexOfNextSmallest)) 
                {
                    indexOfNextSmallest = j;
                }

            }
            tab.Exchange(i, indexOfNextSmallest);
        }
    }

    public static void main(String[] args) {

    }



}

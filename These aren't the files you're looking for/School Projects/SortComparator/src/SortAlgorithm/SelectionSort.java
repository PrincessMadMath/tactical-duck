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
public class SelectionSort implements ISort{

    private static SelectionSort _singleton;

    public static SelectionSort Instance() {
        if (_singleton == null) {
            _singleton = new SelectionSort();
        }

        return _singleton;
    }


    @Override
    public void sort(ObservableArray tab) {

        // Search value for the i th position
        for (int i = 0; i < tab.length; i++) {
            int indexOfNextSmallest = i;
            // Search for the next smallest value
            for (int j = i + 1; j < tab.length; j++) {
                if (tab.Less(j, indexOfNextSmallest)) {
                    indexOfNextSmallest = j;
                }

            }
            tab.exchange(i, indexOfNextSmallest);
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public String getName() {
        return "SelectionSort";
    }

}

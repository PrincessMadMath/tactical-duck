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
public class MergeSort implements ISort {

    private static MergeSort _singleton;

    public static MergeSort Instance() {
        if (_singleton == null) {
            _singleton = new MergeSort();
        }

        return _singleton;
    }

    @Override
    public void sort(ObservableArray tab) {
        Sort(tab, 0, tab.Tab.length-1);
    }

    private void Sort(ObservableArray tab, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            // sort left
            Sort(tab, left, center);
            // sort right
            Sort(tab, center + 1, right);
            // Merge the two array
            Merge(tab, left, center, right);
        }

    }

    private void Merge(ObservableArray tab, int left, int center, int right) {
        Double[] temp = new Double[(right - left) + 1];
        int leftIndex = left;
        int rightIndex = center + 1;

        int i = 0;

        while (leftIndex <= center && rightIndex <= right) {
            if (tab.Less(leftIndex, rightIndex)) {
                temp[i] = tab.Tab[leftIndex++];
            } else {
                temp[i] = tab.Tab[rightIndex++];
            }
            i++;
        }

        while (leftIndex <= center) {
            temp[i] = tab.Tab[leftIndex++];
            i++;
        }

        while (rightIndex <= right) {
            temp[i] = tab.Tab[rightIndex++];
            i++;
        }

        for (i = 0; i < temp.length; i++) {
            tab.place(left + i, temp[i]);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //Integer[] tableau = {3,2,1,5,4,12, 51, 10, 45, 20, 54, 2, 10, 99};
        //MergeSort.sort(tableau, 0, tableau.length-1);
        //Show(tableau);
    }

    @Override
    public String getName() 
    {
        return "MergeSort";
    }

}

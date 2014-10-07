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
public class MergeSort 
{
    public static void Sort(ObservableArray tab, int left, int right)
    {
        if(left < right)
        {
            int center = (left+right)/2;
            // Sort left
            Sort(tab, left, center);
            // Sort right
            Sort(tab, center+1, right);
            // Merge the two array
            Merge(tab, left, center, right);
        }
        
    }
    
    public static void Merge(ObservableArray tab, int left, int center, int right)
    {
        Double[] temp = new Double[(right-left)+1];
        int leftIndex = left;
        int rightIndex = center + 1;
        
        int i=0;
        
        while(leftIndex <= center && rightIndex <= right)
        {
            if(tab.Less(leftIndex, rightIndex))
            {
                temp[i] = tab.Tab[leftIndex++];
            }
            else
            {
                temp[i] = tab.Tab[rightIndex++];
            }
            i++;
        }
        
        while(leftIndex <= center)
        {
            temp[i] = tab.Tab[leftIndex++];
            i++;
        }
        
        while(rightIndex <= right)
        {
            temp[i] = tab.Tab[rightIndex++];
            i++;
        }
        
        for(i = 0 ; i< temp.length ; i++)
        {
            tab.Place(left+i, temp[i]);
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
       //Integer[] tableau = {3,2,1,5,4,12, 51, 10, 45, 20, 54, 2, 10, 99};
       //MergeSort.Sort(tableau, 0, tableau.length-1);
       //Show(tableau);
    }

}

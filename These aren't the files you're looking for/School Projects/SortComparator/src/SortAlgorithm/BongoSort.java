/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAlgorithm;

import Interface.ISort;
import java.util.Random;
import sortcomparator.ObservableArray;

/**
 *
 * @author Mathieu
 */
public class BongoSort implements ISort
{

    private static BongoSort _singleton;
    Random rnd = new Random();

    public static BongoSort Instance() {
        if (_singleton == null) {
            _singleton = new BongoSort();
        }

        return _singleton;
    }
    

    @Override
    public void sort(ObservableArray tab) 
    {
        while(!tab.isSort())
        {
            tab.exchange(rnd.nextInt(tab.length), rnd.nextInt(tab.length));
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public String getName() {
        return "BongoSort";
    }

}

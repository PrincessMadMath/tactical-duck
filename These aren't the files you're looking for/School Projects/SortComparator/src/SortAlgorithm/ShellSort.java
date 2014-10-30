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
public class ShellSort implements ISort
{

    private static ShellSort _singleton;

    public static ShellSort Instance() {
        if (_singleton == null) {
            _singleton = new ShellSort();
        }
        return _singleton;
    }

    @Override
    public void sort(ObservableArray tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
       return "ShellSort";
    }

}

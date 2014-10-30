/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import Interface.ISort;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathieu
 */
public class SortThread implements Runnable {

    private ISort _sortStrategy;
    private ObservableArray _list;
    Thread t;
    private SortComparator _master;

    public SortThread(SortComparator master) 
    {
        _master = master;
    }

    public void StartSort(ISort sort, ObservableArray list) {
        t = new Thread(this);
        _sortStrategy = sort;
        _list = list;

        t.start();
    }

    @Override
    public void run() 
    {
        long startTime = System.currentTimeMillis();
        _sortStrategy.sort(_list);
        _master.onSortEnded((System.currentTimeMillis() - startTime));

    }
}

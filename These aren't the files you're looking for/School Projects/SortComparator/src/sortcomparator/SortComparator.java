/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import Interface.ISort;
import Interface.SortListener;
import SortAlgorithm.BongoSort;
import SortAlgorithm.InsertionSort;
import SortAlgorithm.MergeSort;
import SortAlgorithm.QuickSort;
import SortAlgorithm.SelectionSort;
import SortAlgorithm.ShellSort;
import View.MainView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mathieu
 */
public class SortComparator {

    List<ISort> sortList;

    ObservableArray _observableArray;
    SortListener listener;

    ISort sortStrategy;
    SortThread thread;

    int _arrayLenght = 100;
    double _maxValue = 50.0;

    public SortComparator() {
        _observableArray = new ObservableArray();
        thread = new SortThread(this);
        sortList = new ArrayList<>();
        initSortList();
    }

    private void initSortList() {
        sortList.add(SelectionSort.Instance());
        sortList.add(InsertionSort.Instance());
        sortList.add(ShellSort.Instance());
        sortList.add(MergeSort.Instance());
        sortList.add(QuickSort.Instance());
        sortList.add(BongoSort.Instance());
    }

    public String[] getSortAlgorithmName() {
        int size = sortList.size();
        String[] list = new String[size];
        for (int i = 0; i < size; i++) {
            list[i] = sortList.get(i).getName();
        }
        return list;
    }

    public void addSubscriber(SortListener listener) {
        _observableArray.subsribe(listener);
    }

    public void InitializeArray(int length, double maxValue) {
        _observableArray.setRandomData(length, maxValue);
        _observableArray.randomize();
    }

    public void setSleepTime(int miliSeconds) {
        _observableArray.setSleepTime(miliSeconds);
    }

    String _currentSort;

    public void setupSimulation(String sortName) 
    {
        _currentSort = sortName;
        nbOfSimulationDone = 0;
        average = 0;
        startSimulation();
    }

    public void startSimulation() {
        thread.StartSort(getSort(_currentSort), _observableArray);
    }

    int nbOfSimulationWanted = 20;
    int nbOfSimulationDone = 0;
    long average;

    public void onSortEnded(long time) {
        System.out.println("----------------------------");
        System.out.println("Last result: " + time + "ms");
        nbOfSimulationDone++;
        if (nbOfSimulationDone == 1) {
            average = time;
        } else {
            average = (average * (nbOfSimulationDone - 1) + time) / (nbOfSimulationDone);
        }
        System.out.println("Average: " + average + "ms");

        if (nbOfSimulationDone < nbOfSimulationWanted) {
            _observableArray.randomize();
            startSimulation();
        }

    }

    public ISort getSort(String name) {
        for (ISort sort : sortList) {
            if (name.compareTo(sort.getName()) == 0) {
                return sort;
            }
        }
        return null;
    }

}

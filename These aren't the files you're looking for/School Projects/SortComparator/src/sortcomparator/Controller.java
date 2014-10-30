/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import View.MainView;
import Interface.SortListener;
import SortAlgorithm.MergeSort;

/**
 *
 * @author Mathieu
 */
public class Controller
{
    MainView _view;
    SortComparator _model;
    
    public Controller()
    {}
    
    public void SetMainView(MainView view)
    {
        _view = view;
    }

    public void SetModel(SortComparator model) {
        this._model = model;
    }
    
    public void RandomizeArray(int length, double maxValue)
    {
        _model.InitializeArray(length, maxValue);
    }
    
    public void SetSleepTime(int miliSeconds)
    {
        _model.setSleepTime(miliSeconds);
    }
    
    public void StartSort(String sortName)
    {
        _model.setupSimulation(sortName);
    }

    
}

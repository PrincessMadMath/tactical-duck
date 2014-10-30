/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

import Interface.SortListener;
import Interface.IObservable;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathieu
 */
public class ObservableArray implements IObservable {

    public Double[] Tab;
    public int length;
    
    public int _sleepTime;

    private ArrayList<SortListener> subscribers = new ArrayList<SortListener>();

    int lastExchangeA, lastExchangeB;
    int lastCompareA, lastCompareB;
    int lastPlace;
    
    boolean isGraphicSimulation = true;

    public ObservableArray(int arraySize, int maxRandom) 
    {
        setRandomData(arraySize, maxRandom);
        randomize();
    }

    public ObservableArray() {
    }
    
    int _arraySize;
    double _maxRandom;
    
    public void setRandomData(int arraySize, double maxRandom)
    {
        _arraySize = arraySize;
        _maxRandom = maxRandom;
        Tab = new Double[arraySize];
        length = Tab.length;
        
    }

    public void randomize() 
    {
        Random rand = new Random();

        for (int i = 0; i < Tab.length; i++) {
            Tab[i] = Math.ceil(rand.nextDouble() * _maxRandom);
        }
        // Todo change this!
        for (SortListener sl : subscribers) {
            sl.SetObservableArray(this, _maxRandom);
        }

    }
    
    public boolean isSort()
    {
        boolean isSorted = true;
        for(int i = 0; i< Tab.length-1 && isSorted; i++)
        {
            if(!Less(i, i+1))
            {
                isSorted = false;
            }
        }
        
        return isSorted;
    }

    private void resetColor() {
        lastCompareA = -1;
        lastCompareB = -1;
        lastExchangeA = -1;
        lastExchangeB = -1;
        lastPlace = -1;
    }

    public Boolean Less(int indexA, int indexB) {
        if(isGraphicSimulation)
        {
            resetColor();
            lastCompareA = indexA;
            lastCompareB = indexB;
            notifyListner();
        }
        
        return Tab[indexA].compareTo(Tab[indexB]) < 0;
    }
    
    public int Compare(int indexA, int indexB) {
        if(isGraphicSimulation)
        {
            resetColor();
            lastCompareA = indexA;
            lastCompareB = indexB;
            notifyListner();
        }
        
        return Tab[indexA].compareTo(Tab[indexB]);
    }


    public void exchange(int indexA, int indexB) {
        if(isGraphicSimulation)
        {
            resetColor();
            lastExchangeA = indexA;
            lastExchangeB = indexB;
        }

        Double temp = Tab[indexA];
        Tab[indexA] = Tab[indexB];
        Tab[indexB] = temp;
        
        if(isGraphicSimulation )
        {
            notifyListner();
        }
    }

    public void place(int index, Double value) {
        if(isGraphicSimulation)
        {
            resetColor();
            lastPlace = index;
        }

        Tab[index] = value;
        
        if(isGraphicSimulation)
        {
            notifyListner();
        }
    }

    @Override
    public void subsribe(SortListener listener) {
        subscribers.add(listener);
    }

    @Override
    public void notifyListner() {
        
        for (SortListener sl : subscribers) {
            sl.UpdateArray();
        }

        
        try {
            TimeUnit.MILLISECONDS.sleep(_sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ObservableArray.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Color getColor(int index) {
        if (index == lastExchangeA || index == lastExchangeB) {
            return Color.RED;
        } else if (index == lastCompareA || index == lastCompareB) {
            return Color.GREEN;
        } else if (index == lastPlace) {
            return Color.BLUE;
        } else {
            return Color.BLACK;
        }
    }

    public void setSleepTime(int SleepTime) {
        this._sleepTime = SleepTime;
    }
    
    
}

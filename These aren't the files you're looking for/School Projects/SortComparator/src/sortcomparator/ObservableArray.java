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

    public ObservableArray(int arraySize, int maxRandom) {
        Randomize(arraySize, maxRandom);
    }

    public ObservableArray() {
    }

    public void Randomize(int arraySize, double maxRandom) 
    {
        Random rand = new Random();

        Tab = new Double[arraySize];
        for (int i = 0; i < Tab.length; i++) {
            Tab[i] = rand.nextDouble() * maxRandom;
        }
        length = Tab.length;

        for (SortListener sl : subscribers) {
            sl.SetObservableArray(this, maxRandom);
        }
    }

    private void resetColor() {
        lastCompareA = -1;
        lastCompareB = -1;
        lastExchangeA = -1;
        lastExchangeB = -1;
        lastPlace = -1;
    }

    public Boolean Less(int indexA, int indexB) {
        resetColor();
        lastCompareA = indexA;
        lastCompareB = indexB;

        notifyListner();
        return Tab[indexA].compareTo(Tab[indexB]) < 0;
    }

    public void Exchange(int indexA, int indexB) {
        resetColor();
        lastExchangeA = indexA;
        lastExchangeB = indexB;

        Double temp = Tab[indexA];
        Tab[indexA] = Tab[indexB];
        Tab[indexB] = temp;

        notifyListner();
    }

    public void Place(int index, Double value) {
        resetColor();
        lastPlace = index;

        Tab[index] = value;

        notifyListner();
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

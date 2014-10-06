/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparator;

/**
 *
 * @author Mathieu
 */
public interface SortListener 
{
    public void SetObservableArray(ObservableArray tab, Double maxValue);
    public void UpdateArray();
}

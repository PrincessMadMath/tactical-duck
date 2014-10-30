/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import sortcomparator.ObservableArray;

/**
 *
 * @author Mathieu
 */
public interface ISort 
{
    public void sort(ObservableArray tab);
    
    public String getName();
}

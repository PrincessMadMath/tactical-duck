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
public class SortAlgorithmHelper {

    protected static Boolean Less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void Exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void Show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static Boolean IsSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (Less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

}

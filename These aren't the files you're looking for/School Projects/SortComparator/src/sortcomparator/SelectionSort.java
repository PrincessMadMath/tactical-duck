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
public class SelectionSort extends SortAlgorithmHelper {

    public static void Sort(Double[] tab) {
        // Search value for the i th position
        for (int i = 0; i < tab.length; i++) {
            int indexOfNextSmallest = i;
            // Search for the next smallest value
            for (int j = i + 1; j < tab.length; j++) {
                if (Less(tab[j], tab[indexOfNextSmallest])) 
                {
                    indexOfNextSmallest = j;
                    show(tab,i, j);
                }

            }
            Exchange(tab, i, indexOfNextSmallest);
        }
    }

    public static void main(String[] args) {
        int N = 50;
        StdDraw.setCanvasSize(500, 800);
        StdDraw.setXscale(-1, N+1);
        StdDraw.setPenRadius(.006);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = Math.random();
        SelectionSort.Sort(a);
    }

    private static void show(Double[] a, int i, int min) {
        StdDraw.setYscale(-a.length + i + 1, i);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < i; k++) {
            StdDraw.line(k, 0, k, a[k] * .6);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < a.length; k++) {
            StdDraw.line(k, 0, k, a[k] * .6);
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(min, 0, min, a[min] * .6);
    }

}

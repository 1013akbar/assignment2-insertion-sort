package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    public static void sort(int[] a, PerformanceTracker t) {
        int n = a.length;

        t.start();

        for (int i = 1; i < n; i++) {
            int key = a[i];
            t.addAccess(1);
            int j = i - 1;

            while (j >= 0) {
                t.incComparison();
                t.addAccess(1);

                if (a[j] > key) {
                    a[j + 1] = a[j];
                    t.addAccess(1);
                    t.incSwap();
                    j--;
                } else {
                    break;
                }
            }

            a[j + 1] = key;
            t.addAccess(1);
        }

        t.stop();
    }
}

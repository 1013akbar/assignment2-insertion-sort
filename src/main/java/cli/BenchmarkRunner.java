package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    private static final String CSV_FILE =
            System.getProperty("user.dir") + "/docs/perf_data.csv";


    public static void main(String[] args) {
        String algorithm = "InsertionSort";
        int n = 1000;
        String distribution = "random";
        int repeats = 3;

        if (args.length >= 4) {
            algorithm = args[0];
            n = Integer.parseInt(args[1]);
            distribution = args[2];
            repeats = Integer.parseInt(args[3]);
        }

        System.out.println("Running benchmark:");
        System.out.println("Algorithm: " + algorithm);
        System.out.println("n = " + n + ", distribution = " + distribution + ", repeats = " + repeats);

        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            for (int r = 0; r < repeats; r++) {
                int[] data = generateArray(n, distribution);
                PerformanceTracker tracker = new PerformanceTracker();

                // Run selected algorithm
                if (algorithm.equalsIgnoreCase("InsertionSort")) {
                    InsertionSort.sort(data, tracker);
                } else {
                    System.out.println("Unknown algorithm: " + algorithm);
                    return;
                }


                writer.write(tracker.toCsvRow(n, distribution, r + 1) + "\n");
                writer.flush();

                System.out.println("Run " + (r + 1) + ": " +
                        tracker.getComparisons() + " comparisons, " +
                        tracker.getSwaps() + " swaps, " +
                        tracker.getAccesses() + " accesses, " +
                        tracker.elapsedMillis() + " ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int[] generateArray(int n, String distribution) {
        int[] arr = new int[n];
        Random rand = new Random();

        switch (distribution.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reverse":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            case "nearly":
                for (int i = 0; i < n; i++) arr[i] = i;
                // swap 1% of elements
                for (int i = 0; i < n / 100; i++) {
                    int idx1 = rand.nextInt(n);
                    int idx2 = rand.nextInt(n);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                break;
            case "random":
            default:
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
                break;
        }
        return arr;
    }
}
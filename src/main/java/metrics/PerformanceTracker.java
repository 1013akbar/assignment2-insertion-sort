package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long accesses = 0;
    private long startTimeNs = 0;
    private long endTimeNs = 0;

    public void start() { startTimeNs = System.nanoTime(); }
    public void stop()  { endTimeNs = System.nanoTime(); }
    public long elapsedMillis() { return (endTimeNs - startTimeNs) / 1_000_000; }

    public void incComparison() { comparisons++; }
    public void incSwap() { swaps++; }
    public void addAccess(long n) { accesses += n; }

    // Getters
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }

    public String toCsvRow(int n, String distribution, int repeats) {
        return n + "," + distribution + "," + repeats + "," + comparisons + "," + swaps + "," + accesses + "," + elapsedMillis();
    }
}

import pandas as pd
import matplotlib.pyplot as plt
import os


columns = ["n", "distribution", "run", "comparisons", "swaps", "accesses", "time_ms"]

df = pd.read_csv("docs/perf_data.csv", header=None, names=columns)

print("✅ Loaded data with columns:", df.columns)

os.makedirs("docs/performance-plots", exist_ok=True)

for dist in df['distribution'].unique():
    subset = df[df['distribution'] == dist]
    grouped = subset.groupby('n')['time_ms'].mean().reset_index()

    plt.figure()
    plt.plot(grouped['n'], grouped['time_ms'], marker='o')
    plt.xscale('log')  # log scale for clarity
    plt.title(f"Insertion Sort Time vs n ({dist})")
    plt.xlabel("Input size (n)")
    plt.ylabel("Time (ms)")
    plt.grid(True)
    plt.savefig(f"docs/performance-plots/time_{dist}.png")

for dist in df['distribution'].unique():
    subset = df[df['distribution'] == dist]
    grouped = subset.groupby('n')['comparisons'].mean().reset_index()

    plt.figure()
    plt.plot(grouped['n'], grouped['comparisons'], marker='o')
    plt.xscale('log')
    plt.title(f"Insertion Sort Comparisons vs n ({dist})")
    plt.xlabel("Input size (n)")
    plt.ylabel("Comparisons")
    plt.grid(True)
    plt.savefig(f"docs/performance-plots/comparisons_{dist}.png")


for dist in df['distribution'].unique():
    subset = df[df['distribution'] == dist]
    grouped = subset.groupby('n')['swaps'].mean().reset_index()

    plt.figure()
    plt.plot(grouped['n'], grouped['swaps'], marker='o')
    plt.xscale('log')
    plt.title(f"Insertion Sort Swaps vs n ({dist})")
    plt.xlabel("Input size (n)")
    plt.ylabel("Swaps")
    plt.grid(True)
    plt.savefig(f"docs/performance-plots/swaps_{dist}.png")

print("✅ Plots saved inside docs/performance-plots/")

# Assignment 2: Algorithmic Analysis and Peer Code Review
**Course:** SE 2409 – Database Management Systems  
**Student:** Akbar Khalili

---

## 📌 Project Overview
This repository contains the implementation of **Insertion Sort** with performance tracking and analysis as part of **Assignment 2: Algorithmic Analysis and Peer Code Review**.

The project includes:
- Clean Java implementation of **Insertion Sort** with optimizations for nearly-sorted data.
- Metrics collection (comparisons, swaps, array accesses, runtime).
- CLI-based benchmarking tool.
- Unit tests for correctness and edge cases.
- Empirical performance analysis (plots & CSV data).
- Report analyzing partner’s algorithm (**Selection Sort**).

---

## 📂 Repository Structure
assignment2-insertion-sort/
├── src/main/java/
│ ├── algorithms/InsertionSort.java # Algorithm implementation
│ ├── metrics/PerformanceTracker.java # Collects performance metrics
│ └── cli/BenchmarkRunner.java # CLI benchmarking tool
│
├── src/test/java/
│ └── algorithms/InsertionSortTest.java # Unit tests
│
├── docs/
│ ├── analysis-report.pdf # Partner algorithm analysis report
│ ├── perf_data.csv # Benchmark raw data
│ ├── make_plots.py # Python script to generate plots
│ └── performance-plots/ # Generated plots
│
├── pom.xml # Maven configuration
├── .gitignore # Ignore build/IDE files
└── README.md # Project documentation

---

## 🚀 Getting Started

### Prerequisites
- **Java 17+**
- **Maven 3.8+**
- (Optional) **Python 3 + pandas + matplotlib** (for generating plots)

### Build & Run
Clone the repository:
```bash
git clone https://github.com/1013akbar/assignment2-insertion-sort.git
cd assignment2-insertion-sort

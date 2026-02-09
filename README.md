# Java Random Number Generator & Statistical Analysis

## Description
This is Assignment 1 designed to analyze and compare the performance and statistical accuracy of three built-in Java random number generators. By generating large datasets and applying descriptive statistics, the program demonstrates the **Law of Large Numbers** and verifies how closely Java's generators follow a theoretical uniform distribution.

The analysis covers:
1. **`java.util.Random`**: The standard stream of pseudorandom numbers.
2. **`Math.random()`**: A simple double-generator based on the standard Random class.
3. **`java.util.concurrent.ThreadLocalRandom`**: An isolated generator designed for high-performance concurrent use.


## Statistical Expectations
For a uniform distribution in the range [0, 1), the following values are theoretically expected as the sample size ($n$) increases:
* **Mean**: $0.5$
* **Sample Standard Deviation**: $\approx 0.2887$ (derived from $\sqrt{1/12}$)
* **Min/Max**: Approaching $0.0$ and $1.0$ respectively.

## How to Run
Ensure you have the Java Development Kit (JDK) installed (version 17 or later).

1. **Navigate to the root directory** (the folder containing the `assignment_1` package folder):
   ```bash
   cd path/to/project_root

2. **Compile the program**
   ```bash 
   javac assignment_1/Generator.java

3. **Execute the program**
   ```bash
   java assignment_1.Generator


# The sample output: 
```text
---------------------------------------------------------------------------------------
Generator            n          Mean         StdDev       Min          Max
---------------------------------------------------------------------------------------
java.util.Random     100        0.508801     0.282108     0.010879     0.995321    
Math.random()        100        0.485524     0.307710     0.004167     0.987026
ThreadLocalRandom    100        0.473962     0.293811     0.000898     0.992177
---------------------------------------------------------------------------------------
java.util.Random     10000      0.501261     0.289610     0.000078     0.999997
Math.random()        10000      0.497272     0.286916     0.000133     0.999983    
ThreadLocalRandom    10000      0.494076     0.286495     0.000141     0.999916
---------------------------------------------------------------------------------------
java.util.Random     1000000    0.500169     0.288737     0.000002     1.000000    
Math.random()        1000000    0.500512     0.288707     0.000001     1.000000    
ThreadLocalRandom    1000000    0.500095     0.288580     0.000002     1.000000    
--------------------------------------------------------------------------------------- 

package assignment_1;

/**
 * Name: Rufiz Bayramov
 * Project Name: Assignment 1 
 * Class: Generator
 * Date: February 9, 2026
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator { // class definition

    // instead of user input sample size, we will use three fixed sample sizes of our own 
    // class attribute (Example of Accessibility: private)
    private final int[] sampleSizes = {100, 10000, 1000000}; 

    // the method that would be ussed to populate our arrays with the rand nums
    public ArrayList<Double> populate(int n, int randNumGen) { // a method definition
        ArrayList<Double> list = new ArrayList<>(n); // create empty array of size n
        
        Random randomObj = new Random(); // instance of radnomizer


        // randNumGen decides which type of randomizer we use, 3 types
        for (int i = 0; i < n; i++) {
            if (randNumGen == 1) {
                list.add(randomObj.nextDouble());
            } else if (randNumGen == 2) {
                list.add(Math.random());
            } else {
                list.add(ThreadLocalRandom.current().nextDouble());
            }
        }
        return list; 
    }


    // takes the populated array and computes stats
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        // initialize the stats we wanna compute
        double n = randomValues.size();
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;

        // loops through the values, sums them up and tracks which one is the min max
        for (double val : randomValues) {
            sum += val;
            if (val < min) min = val;
            if (val > max) max = val;
        }
 
        double mean = sum / n; // mean calc

        // std dev calc
        double sumSquaredDiff = 0;
        for (double val : randomValues) {
            sumSquaredDiff += Math.pow(val - mean, 2);
        }
        double stdDev = Math.sqrt(sumSquaredDiff / (n - 1));

        // adding all the results to the array
        ArrayList<Double> results = new ArrayList<>();
        results.add(n);
        results.add(mean);
        results.add(stdDev);
        results.add(min);
        results.add(max);

        return results;
    }

    // output formatter  
    private String currentGenName; 
    // output formatter  
    public void display(ArrayList<Double> results, boolean headerOn) {
        if (headerOn) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("%-20s %-10s %-12s %-12s %-12s %-12s\n", 
                              "Generator", "n", "Mean", "StdDev", "Min", "Max");
            System.out.println("---------------------------------------------------------------------------------------");
        }

        System.out.printf("%-20s %-10.0f %-12.6f %-12.6f %-12.6f %-12.6f\n",
                currentGenName, results.get(0), results.get(1), results.get(2), results.get(3), results.get(4));
    }


    // orchestrator
    public void execute() {
        boolean firstRun = true; // header is needed once, if stats were calced once - false

        // for all tree types of rand generators, create samples
        for (int n : sampleSizes) { 
            for (int genType = 1; genType <= 3; genType++) {
                // Determine generator name once and store in class attribute
                switch (genType) {
                    case 1 -> currentGenName = "java.util.Random";
                    case 2 -> currentGenName = "Math.random()";
                    case 3 -> currentGenName = "ThreadLocalRandom";
                }

                ArrayList<Double> data = populate(n, genType); 
                ArrayList<Double> stats = statistics(data);
                
                display(stats, firstRun); 
                firstRun = false;
            }
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        // Example of Object instantiation
        Generator g = new Generator();
        g.execute();
    }
}
package adt;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class main {

    static int repetitions = 30;

    public static long[] run(int n) {
            
        // ArrayList<Integer> num = new ArrayList<Integer>();
        TreeSet<Integer> num = new TreeSet<Integer>();
        Random r = new Random();
    
        System.out.println("Creating data..");
    
        for(int i = 0; i < n; i++) {
            num.add(r.nextInt(n));
        }
    
        System.out.println("Sorting..");
    
            // Collections.sort(num); // not needed for treeset
    
            //sorts that should be used
    
            //quick
            //merge
            //insertion
    
        System.out.println("Searching..");
    
        long[] times = new long[repetitions];
    
        for(int i = 0; i < repetitions; i++) {
            Integer key = r.nextInt(n);
            long start = System.currentTimeMillis();
            num.contains(key);
            // Collections.binarySearch(num, key);
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
    
            times[i] = elapsedTime;
        }
    
        return times;
    }

    public static void main(String[] args) {

        int sequence[] = {100, 200, 400, 800, 1600, 3200};
        
        long[][] times = new long[sequence.length][repetitions];

        for(int n:sequence) {
            long[] timesN = run(n);
            times[n] = timesN;
        }

        try {
            FileWriter writer = new FileWriter("./data_" + ".csv");
            for(int i = 0; i < sequence.length; i++) {
                writer.append(String.valueOf(sequence[i]));
                if(i < sequence.length - 1) writer.append(",");
            }

            writer.append("\n");

            for(int i = 0; i < repetitions; i++) {
                for(int j = 0; j < sequence.length; j++) {
                    writer.append(String.valueOf(times[j][i]));
                }
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e) {}

    }
}

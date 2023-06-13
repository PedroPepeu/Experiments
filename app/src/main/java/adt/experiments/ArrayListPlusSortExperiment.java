package adt.experiments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class ArrayListPlusSortExperiment implements Experiment{
    private ArrayList<Integer> values;

    private static void myFunction(Integer i) {
        // put lambda function here
    }

    @Override
    public void insert(Integer[] keys) {
        this.values = new ArrayList<>();
        Stream.of(keys).forEach(o -> this.values.add(o)); // lambda function
        Collections.sort(this.values);
    }

    @Override
    public void search(Integer key) {
        Collections.binarySearch(this.values, key);
    }
    
}

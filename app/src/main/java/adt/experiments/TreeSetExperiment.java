package adt.experiments;

import java.util.TreeSet;

public class TreeSetExperiment implements Experiment{

    private TreeSet<Integer> tree;

    public TreeSetExperiment() {
        this.tree = new TreeSet<>();
    }

    @Override
    public void insert(Integer[] keys) {
        this.tree = new TreeSet<>();
        for(Integer key : keys) {
            this.tree.add(key);
        }
    }

    @Override
    public void search(Integer key) {
        this.tree.contains(key);
    }
    


}

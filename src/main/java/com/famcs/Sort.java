package com.famcs;

import java.util.Comparator;
import java.util.List;

public class Sort implements Runnable{

    private List<Integer> arr;
    private Comparator<Integer> comp;

    public List<Integer> getArr() {
        return arr;
    }

    public Sort(List<Integer> arr, Comparator<Integer> comp) {
        this.arr = arr;
        this.comp = comp;
    }


    @Override
    public void run() {
        try {
            arr.sort(comp);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

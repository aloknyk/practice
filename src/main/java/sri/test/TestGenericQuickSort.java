package sri.test;

import sri.sort.GenericQuickSort;

public class TestGenericQuickSort {
    public static void main(String[] args) {
        GenericQuickSort sorter = new GenericQuickSort();
        sorter.sort(new String [] {"dog","zebra","ball","cat","apple"});
    }
}

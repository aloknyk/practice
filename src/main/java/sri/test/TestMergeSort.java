package sri.test;

import sri.sort.MergeSort;

public class TestMergeSort {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        sorter.sort(new int[]{44, 32, 86, 9, 3, 7});
    }
}

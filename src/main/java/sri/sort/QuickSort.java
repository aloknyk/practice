package sri.sort;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class QuickSort {
    public void  sort(int [] unsorted) {
        quickSort(unsorted,0,unsorted.length-1);
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    private void quickSort(@NotNull int[] arr, int low, int high) {
        if(low < high) {
            //partitioned index
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    private int partition(@NotNull int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for(int j=low;j<high;j++) {
            if(arr[j] <= pivot) {
                i+=1;
                //swap i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
            }
        }
        //swap pivot with arr[i+1]
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }


    private void swap(int x,int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}

package com.example.note.algorithm.sort;

/**
 * Created by JIAZ on 2019/2/25.
 */
public class BubblingSort {
    void bubblingSort(int array[], int count){
        for (int i = 0; i < count; i++) {
            // 交换相邻的元素
            for (int j = 1; j < count - i; j++) {
                if (array[j] < array[j-1]){
                    // 交换元素
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
    }
}

package com.example.note.algorithm.sort;

/**
 * Created by JIAZ on 2019/2/22.
 */
public class SelectSort {
    void selectSort(int array[], int count){

        for (int i = 0; i < count; i++) {

            // 最小元素的位置
            int index = i;
            // 找出最小的元素所在的位置
            for (int j = i + 1; j < count; j++) {

                if (array[j] < array[index]){
                    index = j;
                }

            }
            // 交换元素
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;

        }
    }
}

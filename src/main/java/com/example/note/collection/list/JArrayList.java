package com.example.note.collection.list;

import java.util.List;

/**
 * Created by JIAZ on 2019/3/6.
 */
public class JArrayList {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {1, 2}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }

    public int calc(List<List> a) {
        if (a != null) {
            for (List obj : a) {
                calc(obj);
            }
        }
        return 1;
    }

}

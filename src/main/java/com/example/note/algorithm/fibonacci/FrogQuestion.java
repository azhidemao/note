package com.example.note.algorithm.fibonacci;

/**
 * Created by JIAZ on 2019/2/20.
 */

/**
 * question:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * idea:
 * 当n=1时，f(n)=f(1)；
 * 当n=2时，f(n)=f(2-1)+f(2-2)；
 * 当n=3时，f(n)=f(3-1)+f(3-2)+f(3-3)；
 * 当n=n时，f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1) == f(n) = 2*f(n-1)
 */
public class FrogQuestion {

    public int solve(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * solve(target - 1);
    }

    public static void main(String[] args) {
        FrogQuestion frogQuestion = new FrogQuestion();
        System.out.println(frogQuestion.solve(4));
    }
}

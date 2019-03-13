package com.marvinabum.bullsandcows;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Random;

class BullsandcowsJava {

    static Random rand = new Random();
    static int number;
    static int guess;
    static int bulls = 0;
    static int cows = 0;

    public void calculate() {

        bulls=0;
        cows=0;
        HashMap<Integer, Integer> positionsMap = new HashMap<Integer, Integer>();
        int cur_digit = 0;
        int count = 3;
        for(int i=1000; i>=10  ; i= i/10) {
            cur_digit= number / i;
            positionsMap.put(cur_digit, count);
            number = number % i;
            count--;
        }

        positionsMap.put(number, 0);
        count = 3;
        for(int i=1000; i>=10  ; i= i/10) {
            cur_digit= guess / i;
            // check if the cur_digit is already in the map => cow
            // check if the position of the digit is the same as i => bull
            if (positionsMap.containsKey(cur_digit)) {
                if (positionsMap.get(cur_digit) == count) {
                    bulls++;
                }
                else {
                    cows++;
                }
            }

            guess = guess % i;
            count--;
        }

        if (positionsMap.containsKey(guess)) {
            if (positionsMap.get(guess) == 0) {
                bulls++;
            }
            else {
                cows++;
            }
        }
    }
}
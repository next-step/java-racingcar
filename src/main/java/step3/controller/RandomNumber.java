package step3.controller;

import java.util.Random;

public class RandomNumber {
    private static Random rd = new Random();

    public static int getRandomNumber(int bound) {
        return rd.nextInt(bound);
    }
}

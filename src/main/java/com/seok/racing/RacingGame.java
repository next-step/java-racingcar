package com.seok.racing;

import java.util.Random;

public class RacingGame {

    private final static int BOUND = 10;
    private final static int THRESHOLD = 4;

    private final Random random = new Random();
    private int current;

    private final int[][] records;
    private final int times;


    protected RacingGame(int numberOfCars, int times) {
        this.times = times;
        this.records = new int[times][numberOfCars];
    }

    protected void start() {
        while (current < times) {
            move();
        }
    }

    private void move() {
        int[] record = records[current++];
        for (int idx = 0; idx < record.length; idx++) {
            record[idx] = isMovable() ? 1 : 0;
        }
    }

    private boolean isMovable() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }

    protected int[][] getRecords() {
        return records;
    }
}

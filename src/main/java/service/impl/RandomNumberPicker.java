package service.impl;

import service.NumberPicker;

import java.util.Random;

public class RandomNumberPicker implements NumberPicker {

    private static final int MAX_BOUND_NUMBER = 10;
    private final Random random = new Random();

    @Override
    public int pick() {
        return this.random.nextInt(MAX_BOUND_NUMBER);
    }
}

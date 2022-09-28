package com.game.racing.position;

import java.util.concurrent.atomic.AtomicInteger;

public class Position extends AtomicInteger {

    private static Integer MAX_POSITION_VALUE = 0;

    public Position() {
        super(0);
    }

    public void add() {
        compareWithMaxValue(this.addAndGet(1));
    }

    public static void compareWithMaxValue(int position) {
        if (position > MAX_POSITION_VALUE) {
            MAX_POSITION_VALUE = position;
        }
    }

    public static Integer getMaxValue() {
        return MAX_POSITION_VALUE;
    }

    public static void resetMaxValue() {
        MAX_POSITION_VALUE = 0;
    }
}

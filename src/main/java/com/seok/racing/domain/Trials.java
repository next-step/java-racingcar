package com.seok.racing.domain;

public class Trials {

    private static final int TRIALS_MIN_NUMBER = 1;
    private static final int TRIALS_END_NUMBER = 0;

    private int trials;

    public Trials(int trials) {
        if (trials < TRIALS_MIN_NUMBER)
            throw new IllegalArgumentException();
        this.trials = trials;
    }

    protected void attempt() {
        this.trials--;
    }

    protected boolean isEnd() {
        return this.trials == TRIALS_END_NUMBER;
    }
}

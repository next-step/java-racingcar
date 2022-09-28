package com.game.racing.count;

import java.util.concurrent.atomic.AtomicInteger;

public class MovedCarTotalCount extends AtomicInteger {
    public MovedCarTotalCount() {
        super(0);
    }

    public void addCount() {
        this.addAndGet(1);
    }

}

package com.game.racing.position;

import com.game.racing.car.Winner;

import java.util.concurrent.atomic.AtomicInteger;

public class Position extends AtomicInteger {

    public Position() {
        super(0);
    }

    public void add() {
        Winner.compareWithWinnerPosition(this.addAndGet(1));
    }

}

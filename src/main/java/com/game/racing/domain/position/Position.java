package com.game.racing.domain.position;

import com.game.racing.domain.car.Winner;

import java.util.concurrent.atomic.AtomicInteger;

public class Position extends AtomicInteger {

    public Position() {
        super(0);
    }

    public Position(Integer position) {
        super(position);
    }

    public void add() {
        Winner.compareWithWinnerPosition(this.addAndGet(1));
    }

}

package edu.nextstep.camp.racinggame.domain.race;

import java.util.concurrent.atomic.AtomicInteger;

public class Turn {
    private static final int MINIMUM_TOTAL_TURN = 1;
    private static final int INITIAL_TURN = 0;

    private final int totalTurn;
    private final AtomicInteger currentTurn;

    private Turn(int totalTurn) {
        this.totalTurn = totalTurn;
        this.currentTurn = new AtomicInteger(INITIAL_TURN);
    }

    public static Turn of(int totalTurn) {
        if (totalTurn < MINIMUM_TOTAL_TURN) {
            throw new IllegalArgumentException("invalid number of turns: " + totalTurn);
        }

        return new Turn(totalTurn);
    }

    public int total() {
        return totalTurn;
    }

    public int current() {
        return currentTurn.get();
    }

    public void next() {
        currentTurn.incrementAndGet();
    }

    public boolean hasNext() {
        return currentTurn.get() < totalTurn;
    }
}

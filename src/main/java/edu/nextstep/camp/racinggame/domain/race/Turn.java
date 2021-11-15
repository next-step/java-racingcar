package edu.nextstep.camp.racinggame.domain.race;

import java.util.Objects;

public class Turn {
    private static final int MINIMUM_TURN = 0;

    private final int currentTurn;

    private Turn(int turn) {
        this.currentTurn = turn;
    }

    public static Turn of(int turn) {
        if (turn < MINIMUM_TURN) {
            throw new IllegalArgumentException("invalid number of turns: " + turn);
        }

        return new Turn(turn);
    }

    public int toInt() {
        return currentTurn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn) o;
        return Objects.equals(currentTurn, turn.currentTurn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTurn);
    }
}

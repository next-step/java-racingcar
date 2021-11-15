package edu.nextstep.camp.racinggame.domain.race;


import java.util.Iterator;

public class Turns implements Iterator<Turn> {
    private static final int MINIMUM_TOTAL_TURN = 1;
    private static final int INITIAL_TURN = 0;

    private final Turn total;
    private Turn current;

    public static Turns of(int turns) {
        if (turns < MINIMUM_TOTAL_TURN) {
            throw new IllegalArgumentException("invalid number of turns: " + turns);
        }

        return new Turns(turns);
    }

    public Turns(int turns) {
        this.total = Turn.of(turns);
        this.current = Turn.of(INITIAL_TURN);
    }

    public Turn total() {
        return total;
    }

    public Turn current() {
        return current;
    }

    @Override
    public boolean hasNext() {
        return total.toInt() > current.toInt();
    }

    @Override
    public Turn next() {
        current = Turn.of(current().toInt() + 1);
        return current;
    }
}

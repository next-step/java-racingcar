package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MIN_NUMBER_OF_MOVES = 1;

    private final CarName name;
    private final Engine engine;

    private final int moveCount;
    private final List<Boolean> moves;

    public Car(CarName name, Engine engine, int moveCount, List<Boolean> moves) {
        if (moveCount < MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.engine = engine;
        this.moveCount = moveCount;
        this.moves = moves;
    }

    public Car(String name, Engine engine, int moveCount) {
        this(new CarName(name), engine, moveCount, new ArrayList<>());
    }


    public String getName() {
        return this.name.getName();
    }

    public void racingStart() {
        for (int i = 0; i < moveCount; i++) {
            move();
        }
    }

    private void move() {
        moves.add(engine.cycle());
    }

    public List<Boolean> getMoves() {
        return moves;
    }

    public boolean isRoundMove(int round) {
        return moves.get(round);
    }

}

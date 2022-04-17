package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<Boolean> moves;
    private final int moveCount;

    private final Engine engine;

    public Car(Engine engine, int moveCount) {
        this.engine = engine;
        this.moves = new ArrayList<>();
        this.moveCount = moveCount;
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

}

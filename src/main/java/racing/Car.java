package racing;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MIN_NUMBER_OF_MOVES = 1;

    private final String carName;

    private final List<Boolean> moves;
    private final int moveCount;

    private final Engine engine;

    public Car(String carName, Engine engine, int moveCount) {
        if (moveCount < MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
        this.engine = engine;
        this.moves = new ArrayList<>();
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return this.carName;
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

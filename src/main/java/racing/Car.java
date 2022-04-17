package racing;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<Boolean> moves;
    private final int moveCount;

    private final Engine engine;

    public Car(Engine engine, int moveCount) {
        this.engine = engine;
        this.moves = new ArrayList<>();
        moves.add(true);
        this.moveCount = moveCount;
    }

    public void racingStart() {
        for (int i = 0; i < moveCount - 1; i++) {
            move();
        }
    }

    private void move() {
        moves.add(engine.cycle());
    }

    public List<Boolean> getMoves() {
        return moves;
    }

    public void printMove(int index) {
        if (moves.size() < index) {
            throw new IllegalReceiveException();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            if (moves.get(i)) {
                result.append("-");
            }
        }

        System.out.println(result);

    }

}

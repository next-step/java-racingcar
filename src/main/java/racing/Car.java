package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final CarName name;
    private final Engine engine;

    private final MoveCount moveCount;
    private final List<Boolean> moves;

    public Car(CarName name, Engine engine, MoveCount count, List<Boolean> moves) {
        this.name = name;
        this.engine = engine;
        this.moveCount = count;
        this.moves = moves;
    }

    public Car(String name, Engine engine, int moveCount) {
        this(new CarName(name), engine, new MoveCount(moveCount), new ArrayList<>());
    }


    public String getName() {
        return this.name.getName();
    }

    public void racingStart() {
        for (int i = 0; moveCount.isUnderCount(i); i++) {
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

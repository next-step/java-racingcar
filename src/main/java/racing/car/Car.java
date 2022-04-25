package racing.car;

import java.util.ArrayList;

public class Car {

    private final CarName name;
    private final Engine engine;

    private final MoveCount moveCount;
    private final Moves moves;

    public Car(CarName name, Engine engine, MoveCount count, Moves moves) {
        this.name = name;
        this.engine = engine;
        this.moveCount = count;
        this.moves = moves;
    }

    public Car(String name, Engine engine, int moveCount) {
        this(new CarName(name), engine, new MoveCount(moveCount), new Moves(new ArrayList<>()));
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
        moves.addMove(engine.cycle());
    }

    public int getMoveDistance() {
        return moves.getDistance();
    }

    public int getRoundDistance(int round) {
        return moves.getRoundDistance(round);
    }

    public int getMovesCount() {
        return this.moves.getTotalMovesCount();
    }
}

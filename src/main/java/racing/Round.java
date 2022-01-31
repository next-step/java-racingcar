package racing;

import java.util.List;

public class Round {

    private final int roundNumber;
    private final MoveRule moveRule;

    public Round (int roundNumber, MoveRule moveRule) {
        this.roundNumber = roundNumber;
        this.moveRule = moveRule;
    }

    public RoundResult play(List<Car> cars) {
        for(Car car : cars) {
            move(moveRule.makeValue(), car);
        }
        return new RoundResult(cars);
    }

    private void move(int value, Car car) {
        if(value >= moveRule.getMoveCondition()) {
            car.move();
        }
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}

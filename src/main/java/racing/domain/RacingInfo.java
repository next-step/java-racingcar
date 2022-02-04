package racing.domain;

import java.util.List;

public class RacingInfo {

    private final List<Car> cars;
    private final Round round;
    private final MoveRule moveRule;

    public RacingInfo(List<Car> cars, Round round, MoveRule moveRule) {
        this.cars = cars;
        this.round = round;
        this.moveRule = moveRule;
    }

    public static RacingInfo init(String carNames, int roundNumber) {
        final List<Car> cars = CarGenerator.createCars(carNames);
        MoveRule moveRule = initMoveRule(4);
        Round round = new Round(roundNumber);

        return new RacingInfo(cars, round, moveRule);
    }

    private static MoveRule initMoveRule(int moveCondition) {
        return new MoveRule(moveCondition);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }
}

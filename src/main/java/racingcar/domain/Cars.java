package racingcar.domain;

import racingcar.utils.RandomNumber;

import java.util.List;

public class Cars {
    
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = values;
    }

    public GameRecord play() {
        GameRecord gameRecord = new GameRecord();
        for (Car car : values) {
            car.move(randomMoveStrategy());
            gameRecord.add(car.getPosition());
        }
        return gameRecord;
    }

    private MoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy(RandomNumber.generate());
    }
}

package racingcar.domain;

import java.util.List;

public class Cars {
    
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = values;
    }

    public GameRecord play() {
        GameRecord gameRecord = new GameRecord();
        for (Car car : values) {
            car.move(new RandomMoveStrategy());
            gameRecord.add(car.getPosition());
        }
        return gameRecord;
    }
}

package racingcar.backend.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> values;

    public static Cars create(String[] names) {
        return new Cars(Arrays.asList(names).stream()
                .map(Car::new).collect(Collectors.toList()));
    }

    public Cars(List<Car> values) {
        this.values = values;
    }

    public GameRecord play() {
        GameRecord gameRecord = new GameRecord();
        for (Car car : values) {
            gameRecord.add(car.move(new RandomMoveStrategy()));
        }
        return gameRecord;
    }

    public List<Car> getValues() {
        return values;
    }
}

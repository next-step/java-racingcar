package racingcar.domain;

import racingcar.common.Constant;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final String racingCarNames;
    private final int racingCount;
    private static final String SPLIT_LETTER = ",";

    public RacingGame(String racingCarNames, int racingCount) {
        validRacingCount(racingCount);
        validRacingCarNames(racingCarNames);
        this.racingCarNames = racingCarNames;
        this.racingCount = racingCount;
    }

    public Cars createCars() {
        List<Car> cars = Arrays.stream(racingCarNames.split(SPLIT_LETTER))
                .map(carName -> new Car(new Name(carName)))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public List<Cars> getRacingGameResult() {
        List<Cars> records = new ArrayList<>();
        Cars cars = createCars();

        for (int i = 0; i < racingCount; i++) {
            Cars postRaceCars = race(cars, new RandomMovingStrategy());
            records.add(postRaceCars);
            cars = postRaceCars;
        }
        return records;
    }

    public Cars race(Cars cars, MovingStrategy movableGenerator) {

        List<Car> racingResult = cars.getValue().stream()
                .map(car -> car.move(movableGenerator))
                .collect(Collectors.toList());

        return new Cars(racingResult);
    }

    private void validRacingCount(int racingCount) {
        if (racingCount < 0) {
            throw new IllegalArgumentException("racing count is not available");
        }
    }

    private void validRacingCarNames(String racingCarNames) {
        if (racingCarNames.equals(Constant.BLANK) || racingCarNames.equals(Constant.BLANK_STRING) || racingCarNames.isEmpty()) {
            throw new IllegalArgumentException("racing car name is wrong");
        }
    }
}

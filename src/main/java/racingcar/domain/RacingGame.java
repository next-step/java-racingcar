package racingcar.domain;

import com.sun.tools.internal.jxc.ap.Const;
import racingcar.common.Constant;
import racingcar.strategy.MovingStrategy;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Cars;
import racingcar.strategy.RandomMovingStrategy;

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
        List<String> carNames = Arrays.stream(racingCarNames.split(SPLIT_LETTER))
                .collect(Collectors.toList());

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Name name = new Name(carName);
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Cars> getRacingResult() {
        List<Cars> records = new ArrayList<>();
        Cars cars = createCars();
        for (int i = 0; i < racingCount; i++) {
            Cars postRaceCars = race(cars, new RandomMovingStrategy());
            records.add(postRaceCars);
        }
        return records;
    }

    public Cars race(Cars cars, MovingStrategy movableGenerator) {
        for (Car car : cars.getValue()) {
            car.move(movableGenerator);
        }
        return cars;
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

package step4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final Random random = new Random();
    private static final int BOUND = 10;
    private static final int MAX_CAR_NAME_NUMBER = 5;
    private static final String CAR_NAME_COMMA = ",";

    public List<Car> start(String carNames) {
        return car(setCars(carNames));
    }

    public List<Car> car(String[] racingCars) {
        return Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getRandom() {
        return random.nextInt(BOUND);
    }

    public void carMove(List<Car> cars) {
        cars.forEach(car -> car.move(getRandom()));
    }

    public String[] setCars(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("경주할 자동차 이름이 비어있습니다.");
        }
        String[] racers = carName.split(CAR_NAME_COMMA);
        if (racers.length > MAX_CAR_NAME_NUMBER) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다.");
        }
        return racers;
    }
}

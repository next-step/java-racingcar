package edu.nextstep.camp.racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final int CAR_MIN_COUNT = 2;
    private static final int CAR_MAX_COUNT = 20;

    private final Random random = new Random();

    private final List<Car> cars;

    public Cars(String... carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        nameCountCheck(cars);
        duplicateNameCheck(cars);
        this.cars = cars;
    }

    private static void nameCountCheck(List<Car> carNames) {
        int carCount = carNames.size();

        if (CAR_MIN_COUNT > carCount || carCount > CAR_MAX_COUNT) {
            throw new IllegalArgumentException("자동차 수는 2~20대로 설정 하세요.");
        }
    }

    private static void duplicateNameCheck(List<Car> carNames) {
        Set<Car> carNamesSet = new HashSet<>(carNames);

        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차는 중복될 수 없습니다.");
        }
    }

    public RacingResult moveCars() {
        cars.forEach(car -> car.move(randomInt()));

        return new RacingResult(cars);
    }

    public List<String> winners() {
        Optional<Car> carOpt = cars.stream()
                .max((car, compareCar) -> car.maxPosition(compareCar.currentPosition()));

        return cars.stream().filter(c -> c.isWinner(carOpt.get())).map(Car::getName).collect(Collectors.toList());
    }

    protected int randomInt() {
        return random.nextInt(10);
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> carList;
    private int tryCount;

    public RacingCarGame(List<String> carNames, int tryCount) {
        this.carList = createCars(carNames);
        this.tryCount = tryCount;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public List<Car> playOneRound() {
        if (!isEnd()) {
            carList.forEach(Car::tryMove);
            tryCount--;
        }
        return getCarList();
    }

    public boolean isEnd() {
        return tryCount <= 0;
    }

    public List<String> getWinnerName() {
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max().getAsInt();
    }
}

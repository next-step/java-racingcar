package study.step5.domain.model;


import study.step5.domain.strategy.CarMoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",|:";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(DELIMITER)) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void startRacing() {
        for (Car car : cars) {
            car.move(new CarMoveStrategy());
        }
    }

    public int getWinnerPosition() {
        return Collections.max(cars).getPosition();
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        List<Car> winners = cars.stream()
                .filter(car -> isWinner(car, winnerPosition))
                .collect(Collectors.toList());

        return winners;
    }

    private Boolean isWinner(Car car, int winnerPosition) {
        return car.isWinner(winnerPosition);
    }

    public List<Car> getCars() {
        return cars;
    }
}

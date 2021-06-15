package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCars(String carName) {
        cars.add(new Car(carName));
    }

    public void move(RacingRandom racingRandom) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(racingRandom.isMove());
        }
    }

    public List<Car> selectWinners() {
        int winnerScore = selectWinnerScore();

        return this.cars.stream()
                .filter(car -> car.isWinner(winnerScore))
                .collect(Collectors.toList());
    }

    private int selectWinnerScore() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt()
                ;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

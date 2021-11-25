package study.racingcar.domain;

import study.racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> endRound(MoveStrategy moveStrategy){
        List<Car> resultCars = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            resultCars.add(new Car(car));
        }
        return resultCars;
    }

    public List<Car> getResult(){
        return cars;
    }

    public Cars getResultCars(){
        return new Cars(cars);
    }

    public List<Car> getWinner() {
        return getWinners(maxPosition());
    }

    private int maxPosition() {
        int maxPosition = 0;
        return cars.stream()
                        .mapToInt(value -> value.getMaxPosition(maxPosition))
                        .max()
                        .orElse(0);
    }

    private List<Car> getWinners(int maxPosition) {
        return cars.stream()
                        .filter(car -> car.isWinnerPosition(maxPosition))
                        .collect(Collectors.toList());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

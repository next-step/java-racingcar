package study.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {

    private int maxPosition;
    private List<Car> cars;

    public GameWinner(List<Car> cars) {
        this.maxPosition = getMaxPosition(cars);
        this.cars = cars;
    }

    public int getMaxPosition(List<Car> carList) {
        List<Integer> positionList = new ArrayList<>();

        for(Car car : carList) {
            positionList.add(car.currentPosition());
        }

        return Collections.max(positionList);
    }

    public List<String> findGameWinner() {

        return cars.stream()
                .filter(car -> car.currentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

package study.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameWinner {

    private int maxPosition;
    private List<Car> carList;

    public GameWinner(List<Car> carList) {
        this.maxPosition = getMaxPosition(carList);
        this.carList = carList;
    }

    public int getMaxPosition(List<Car> carList) {
        List<Integer> positionList = new ArrayList<>();

        for(Car car : carList) {
            positionList.add(car.currentPosition());
        }

        return Collections.max(positionList);
    }

    public List<String> findGameWinner() {

        return carList.stream()
                .filter(car -> car.currentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

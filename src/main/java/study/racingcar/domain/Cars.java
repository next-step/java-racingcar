package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> ragingCarList = new ArrayList<>();

    public Cars(List<Car> ragingCarList) {
        this.ragingCarList = ragingCarList;
    }

    public void moveRacingCar() {
        for (Car car : ragingCarList) {
            car.moveCar(new RandomMovingStrategy());
        }
    }

    public List<Car> getRagingCarList() {
        return ragingCarList;
    }


    public List<Car> getRacingWinners() {
        int maxPosition = ragingCarList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();

        return ragingCarList.stream()
                .filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }
}

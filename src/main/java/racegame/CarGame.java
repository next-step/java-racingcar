package racegame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    public static final int CHECK_NUMBER = 4;
    private List<Car> carList;

    public CarGame(List<Car> carList) {
        this.carList = carList;
    }

    public void goStepGame() {
        for (Car car : carList) {
            goGame(car);
        }
        CarView.carPrint(carList);
    }

    private void goGame(Car car) {
        int randomInt = (int) (Math.random() * 10) + 1;
        if (randomInt > CHECK_NUMBER) {
            car.move();
        }
    }

    public void winnerCar() {
        List<Integer> carListGoStepInt = carList.stream()
            .map(car -> car.getGoStep())
            .collect(Collectors.toList());

        int max = Collections.max(carListGoStepInt);

        carList = carList.stream()
            .filter(car -> car.sameCheck(max))
            .collect(Collectors.toList());

        CarView carview = new CarView();
        carview.winnerPrint(carList);
    }

}

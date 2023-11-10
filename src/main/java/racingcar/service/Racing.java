package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RandomNumber;
import racingcar.view.ResultView;

import java.util.*;

public class Racing {

    private static final RandomNumber RANDOM_NUMBER = new RandomNumber();

    public void startRacing(String inputCarNames, int tryCount) {
        Cars cars = new Cars(inputCarNames);
        List<Car> carList = cars.getCarList();
        System.out.println("\n실행결과");

        for (int i = 0; i < tryCount; i++) {
            moveCars(carList);
            System.out.println("");
        }
        ResultView.printWinner(cars.getWinners());
    }

    private void moveCars(List<Car> cars) {

        for (Car car : cars) {
            car.move(RANDOM_NUMBER.getRandomNumber());
            ResultView.printPosition(car.name(), car.position());
        }
    }
}
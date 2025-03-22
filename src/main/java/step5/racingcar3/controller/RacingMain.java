package step5.racingcar3.controller;

import java.util.ArrayList;
import java.util.List;
import step5.racingcar3.domain.Car;
import step5.racingcar3.domain.CarEngine;
import step5.racingcar3.domain.CarList;
import step5.racingcar3.domain.CarName;
import step5.racingcar3.domain.PositiveNumber;
import step5.racingcar3.domain.RacingGame;
import step5.racingcar3.view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> inputCarNames = inputView.getCarNames();
        int inputNumberOfRounds = inputView.getNumberOfRounds();

        CarList carList = initCars(inputCarNames);
        PositiveNumber numberOfRounds = initNumberOfRounds(inputNumberOfRounds);

        RacingGame racingGame = new RacingGame(carList, numberOfRounds);
        racingGame.start();
        racingGame.end();

        CarList winners = racingGame.winners();





    }


    public static CarList initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName), new CarEngine()));
        }
        return new CarList(cars);
    }

    public static PositiveNumber initNumberOfRounds(int numberOfRounds) {
        return new PositiveNumber(numberOfRounds);
    }

}

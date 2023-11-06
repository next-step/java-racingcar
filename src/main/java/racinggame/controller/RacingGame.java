package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.Split;
import racinggame.factory.CarFactory;
import racinggame.strategy.RandomMove;
import racinggame.ui.InputView;
import racinggame.ui.OutputView;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carName = inputView.carName();
        int racingCount = inputView.racingCount();

        Cars cars = new Cars(new CarFactory().generateCar(new Split().toCarNames(carName), new RandomMove()));
        OutputView outputView = new OutputView();

        for (int step = 0; step < racingCount; step++) {
            outputView.printRacing(cars.racing());
        }
        outputView.printWinners(cars.findWinners());
    }

}

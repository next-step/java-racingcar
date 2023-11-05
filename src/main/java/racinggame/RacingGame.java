package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RandomNumber;
import racinggame.ui.InputView;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carName = inputView.carName();
        int racingCount = inputView.racingCount();

        Cars cars = new Cars(new FactoryCar().generateCar(new Split().toCarNames(carName), new RandomNumber()));
        cars.startRacing(racingCount);
    }

}

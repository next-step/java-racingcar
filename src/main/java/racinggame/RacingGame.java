package racinggame;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carSize = inputView.carSize();
        int racingCount = inputView.racingCount();

        Cars cars = new Cars(new FactoryCar().generateCar(carSize, new RandomNumber()));
        cars.startRacing(racingCount);
    }

}

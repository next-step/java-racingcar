package racing;


import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputView;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        int carNo = inputView.getNumberOfCars();
        int roundNo = inputView.getNumberOfChances();

        Cars cars = Cars.create(carNo);

        RacingGame racingGame = new RacingGame(cars, roundNo);
        racingGame.validateInput(carNo, roundNo);
        racingGame.play();

        scanner.close();
    }
}

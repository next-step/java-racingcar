package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

        String carNames = input.getCarNames();
        MoveChecker moveChecker = new MoveChecker();
        Cars cars = CarsFactory.createCars(carNames, moveChecker);

        int tryCount = input.getTryCount();

        Game game = new Game(cars, tryCount, moveChecker);
        game.start();
    }
}

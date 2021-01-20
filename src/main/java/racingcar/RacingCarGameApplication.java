package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        String carNames = input.getCarNames();
        int tryCount = input.getTryCount();
        List<String> cars = InputParser.parseCarNames(carNames);
        MoveChecker moveChecker = new MoveChecker();

        Game game = new Game(cars, tryCount, moveChecker);
        game.start();
    }
}

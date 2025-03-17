package step3;

import java.util.Random;

public class RacingCarApplication {

    public static void main(String[] args) {
        int numberOfCars = InputView.getInput("자동차 대수는 몇 대 인가요?");
        int rounds = InputView.getInput("시도할 회수는 몇 회 인가요?");

        Random random = new Random();
        MovingStrategy movingStrategy = new RandomMovingStrategy(random);
        Cars cars = new Cars(numberOfCars, movingStrategy);

        RacingGame racingGame = new RacingGame(cars, rounds);
        racingGame.startGame();

        ResultView.printResult(racingGame.result());
    }
}

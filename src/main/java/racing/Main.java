package racing;

import java.security.NoSuchAlgorithmException;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(InputView.getNames(), InputView.getTime());
        // 진행 가능한 동안 반복
        while (racingGame.canContinue()) {
            List<Car> cars = racingGame.move();
            ResultView.printAll(cars);
        }
        ResultView.printWinners(RacingGame.getWinners(racingGame.getCars()));

    }
}

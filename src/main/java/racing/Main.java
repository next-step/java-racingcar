package racing;

import java.security.NoSuchAlgorithmException;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        try {
            RacingGame racingGame = new RacingGame(InputView.getNames(), InputView.getTime());
            // 진행 가능한 동안 반복
            while(racingGame.canContinue()) {
                List<Car> cars = racingGame.move();
                ResultView.printAll(cars);
            }
            ResultView.printWinners(racingGame.getWinners());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}

package step3;

import static java.lang.System.exit;
import static step3.Constants.INITIAL_TRY_COUNT;
import static step3.Constants.MAX_TRY_COUNT;

import java.security.spec.InvalidParameterSpecException;

public class RacingGameMain {

    public static void main(String[] args) throws InterruptedException {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingGame racingGame = null;

        int time = 0;
        int carCount = 0;
        int currentRetryCount = INITIAL_TRY_COUNT;
        int maxTries = MAX_TRY_COUNT;

        while(true) {
            try {
                time = inputView.enterTime();
                carCount = inputView.enterCarCount();

                racingGame = new RacingGame(time, carCount);
                resultView.printTitle();
                for (int i = 0; i < racingGame.getTime(); ++i) {
                    resultView.printResult(racingGame.move());
                    Thread.sleep(1000);
                    System.out.println();
                }
                exit(0);

            } catch (InvalidParameterSpecException e) {
                if (++currentRetryCount == maxTries) {
                    System.out.println(e.getMessage());
                    exit(1);
                }
            }
        }
    }
}

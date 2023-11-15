package racing;

import racing.domain.racing.Racing;
import racing.domain.racing.RandomNumber;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingApp {

    private static final Random random = new Random();

    public static void main(String[] args) {
        String inputNames = InputView.getInputNames();
        int attemptCount = InputView.getNumberOfAttempts();

        Racing racing = new Racing(inputNames, attemptCount);
        ResultView.showCurrentPosition(racing.result());
        ResultView.showWinners(racing.winners());
    }
}

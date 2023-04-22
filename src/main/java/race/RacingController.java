package race;

import race.domain.car.RandomMoving;
import race.domain.racing.Racing;
import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class RacingController {
    public static void main(String[] args) {
        final List<String> carNames = InputView.carNames();
        final int matchCount = InputView.numberOfAttempts();

        final Racing racing = new Racing(matchCount, carNames);

        ResultView.printScore(racing.race(new RandomMoving()));
    }
}

package racing;

import java.util.List;

public class RacingController {
    public static void main(String[] args) {
        final int matchCount = InputView.numberOfAttempts();
        final List<String> carNames = InputView.carNames();

        final Racing racing = new Racing(matchCount,carNames);

        ResultView.printScore(racing.race());
    }
}

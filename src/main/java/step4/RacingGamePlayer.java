package step4;

import step4.domain.Cars;
import step4.domain.Racing;
import step4.view.RacingInputView;
import step4.view.RacingOutputView;

import java.util.List;

public class RacingGamePlayer {

    public void playRacingGame() {
        final List<String> carNames = RacingInputView.carNames();
        final int tryCount = RacingInputView.tryCount();

        final Racing racing = randomMovementRacing(carNames, tryCount);

        RacingOutputView.printRacingResult(racing.playAndGenerateResults());
    }

    private Racing randomMovementRacing(List<String> carNames, int tryCount) {
        return Racing.randomMoving(Cars.from(carNames), tryCount);
    }

    public static void main(String[] args) {
        final RacingGamePlayer racingGamePlayer = new RacingGamePlayer();

        racingGamePlayer.playRacingGame();
    }

}

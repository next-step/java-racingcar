package step5;

import step5.domain.Cars;
import step5.domain.Racing;
import step5.domain.TryCount;
import step5.view.RacingInputView;
import step5.view.RacingOutputView;

import java.util.List;

public class RacingGamePlayer {

    public void playRacingGame() {
        final List<String> carNames = RacingInputView.carNames();
        final TryCount tryCount = new TryCount(RacingInputView.tryCount());

        final Racing racing = randomMovementRacing(carNames, tryCount);

        RacingOutputView.printRacingResult(racing.playAndGenerateResults());
    }

    private Racing randomMovementRacing(List<String> carNames, TryCount tryCount) {
        return Racing.randomMoving(Cars.from(carNames), tryCount);
    }

    public static void main(String[] args) {
        final RacingGamePlayer racingGamePlayer = new RacingGamePlayer();

        racingGamePlayer.playRacingGame();
    }

}

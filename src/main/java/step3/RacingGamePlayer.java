package step3;

import step3.domain.Cars;
import step3.domain.Racing;
import step3.view.RacingInputView;
import step3.view.RacingOutputView;

public class RacingGamePlayer {

    public void playRacingGame() {
        final int carCount = RacingInputView.carCount();
        final int tryCount = RacingInputView.tryCount();

        final Racing racing = randomMovementRacing(carCount, tryCount);

        RacingOutputView.printRacingResult(racing.playAndGenerateResults());
    }

    private Racing randomMovementRacing(int carCount, int tryCount) {
        return Racing.randomMoving(Cars.from(carCount), tryCount);
    }

    public static void main(String[] args) {
        final RacingGamePlayer racingGamePlayer = new RacingGamePlayer();

        racingGamePlayer.playRacingGame();
    }

}

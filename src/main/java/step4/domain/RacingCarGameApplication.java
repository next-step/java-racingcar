package step4.domain;

import step4.domain.racing.RacingCarGame;
import step4.startegy.RacingMove;
import step4.view.InputView;
import step4.view.ResultView;

public final class RacingCarGameApplication {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingCarGameApplication() {
        this.inputView = InputView.getInstance();
        this.resultView = ResultView.getInstance();
    }

    public final void start() {
        RacingCarGame racingCarGame = new RacingCarGame(inputView.requestDto());
        resultView.printRacingEndMessage();
        while (racingCarGame.hasNext()) {
            racingCarGame.move(new RacingMove());
            resultView.print(racingCarGame.responseDto());
            racingCarGame.nextRound();
        }
        resultView.print(racingCarGame.winners());
    }

}

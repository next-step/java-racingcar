package me.daeho.step5;

import me.daeho.step5.domain.RacingGame;
import me.daeho.step5.view.InputView;
import me.daeho.step5.view.ResultView;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private RacingGame racingGame;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        inputView.inputCarNames().inputTime();
        racingGame = RacingGame.init(inputView.getCarNames(), inputView.getTime());
    }

    public void run() {
        if(racingGame == null) {
            resultView.showMessage("게임을 먼저 시작해주세요");
            return;
        }

        while(racingGame.hasNext()) {
            resultView.showResult(racingGame.move());
        }
    }

    public void winners() {
        if(racingGame == null) {
            resultView.showMessage("게임을 먼저 시작해주세요");
            return;
        }

        if(racingGame.hasNext()) {
            resultView.showMessage("아직 우승자가 정해지지 않았습니다.");
            return;
        }

        resultView.showWinners(racingGame.winningCars());
    }
}

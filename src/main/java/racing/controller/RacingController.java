package racing.controller;

import racing.model.CarNameParser;
import racing.model.GameTurn;
import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;


public class RacingController {

    private final RacingGame racingGame;
    private final GameTurn gameTurn;

    public RacingController() {
        InputView inputView = new InputView();
        this.gameTurn = new GameTurn(inputView.getTurnCount());
        CarNameParser carNameParser = new CarNameParser(inputView.getParticipationList());
        this.racingGame = new RacingGame(carNameParser.parse());
    }

    /**
     * 게임 시작 메서드 1 턴씩 진행하며 게임이 끝날때까지 반복된다.
     */
    public void play() {
        ResultView resultView = new ResultView();
        RacingGame racingGame = gameTurn.play(this.racingGame, resultView);
        finish(racingGame, resultView);
    }


    /**
     * 게임을 끝내고 우승자를 보여주는 메서드
     */
    private void finish(RacingGame racingGame, ResultView resultView) {
        resultView.drawWinner(racingGame.findWinners());
    }

    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.play();
    }

}

package racing.controller;

import java.util.List;

import racing.model.RacingCar;
import racing.model.RacingGame;
import racing.util.Validation;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    private final RacingGame racingGame;
    private final Validation validation;
    private int gameTurn;

    public RacingController() {
        this.racingGame = new RacingGame();
        this.validation = new Validation();
    }

    /**
     * InputView 에서 자동차 갯수와 게임 실행 횟수를 입력받아 게임을 설정함
     */
    public void setUpGame() {
        InputView inputView = new InputView();
        inputView.init();
        if (validation.isZero(inputView.getTurnCount())) {
            inputView.reStart();
        }
        racingGame.setUp(inputView.getParticipationList());
        this.gameTurn = inputView.getTurnCount();

    }

    /**
     * 게임 시작 메서드 1 턴씩 진행하며 게임이 끝날때까지 반복된다.
     */
    public void play() {
        ResultView resultView = new ResultView();
        for (int i = 0; i < gameTurn; i++) {
            List<Integer> randomValue = racingGame.createRandomValue();
            List<RacingCar> movedCarList = racingGame.moveAndStop(randomValue);
            resultView.turnResultView(movedCarList);
        }
        finish(resultView);
    }

    private void finish(ResultView resultView) {
        resultView.drawWinner(racingGame.setWinner());
    }

    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.setUpGame();
        racingController.play();
    }

}

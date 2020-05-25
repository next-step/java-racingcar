package step3;

import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Map;

public class RacingGameController {
    private RacingGame racingGame;
    private ResultView resultView = new ResultView();
    private String names;
    private int time;

    public RacingGameController() {
        input();
        makeNewRacingGame();
        racingStart();
        printRacingWithName();
        printWinner();
    }

    public void input() {
        InputView inputView = new InputView();
        names = inputView.inputCarsName();
        time = inputView.inputTimeCount();
    }

    public void makeNewRacingGame() {
        racingGame =  new RacingGame(names,time);
    }

    public void racingStart() {
        racingGame.racingStart();
    }

    public void printRacing() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        Map<Integer, int[]> record = racingGame.getRecord();
        for (int i = 0; i < time; i++) {
            resultView.printRoundCarPosition(record.get(i));
        }
    }

    public void printWinner() {
        resultView.printRacingWinner(racingGame.getWinner());
    }

    public void printRacingWithName() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        Map<Integer, int[]> record = racingGame.getRecord();
        for (int i = 0; i < time; i++) {
            resultView.printRoundCarPositionWithName(racingGame.getCars(), record.get(i));
        }
    }
}

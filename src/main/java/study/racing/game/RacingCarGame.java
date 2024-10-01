package study.racing.game;

import study.racing.car.RacingCar;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

import java.util.ArrayList;

public class RacingCarGame {

    private final InputView inputView;
    private final ResultView resultView = new ResultView();
    private static final int MOVE_CRITERIA = 4;

    public RacingCarGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarCount(); i++) {
            racingCars.add(new RacingCar());
        }

        resultView.printResult();
        for (int i = 0; i < inputView.getGameCount(); i++) {
            simulate(racingCars);
            separateRound(i, inputView.getGameCount());
        }

        resultView.gameEnd();
    }

    private void simulate(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            move(racingCar, random());
            resultView.printCarPosition(racingCar.getCurrentPosition());
        }
    }

    private void move(RacingCar racingCar, int randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            racingCar.move();
        }
    }

    private int random() {
        return (int) (Math.random() * 10);
    }

    private void separateRound(int nowRound, int gameCount) {
        if (nowRound != gameCount - 1) {
            resultView.separateGameRound();
        }
    }

}

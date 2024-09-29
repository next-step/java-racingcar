package study.step3.game;

import study.step3.car.RacingCar;
import study.step3.message.ExceptionMessage;
import study.step3.ui.InputView;
import study.step3.ui.ResultView;

import java.util.ArrayList;

public class RacingCarGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void play() {
        this.inputView.questionCarCount();
        int carCount = validateCarCount(this.inputView.getCount());
        this.inputView.questionGameCount();
        int gameCount = validateGameCount(this.inputView.getCount());

        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }

        this.resultView.printResult();
        for (int i = 0; i < gameCount; i++) {
            simulate(racingCars);
            separateRound(i, gameCount);
        }

        this.resultView.gameEnd();
    }

    private int validateCarCount(int carCount) {
        if (carCount < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT_MESSAGE.getMessage());
        }
        return carCount;
    }

    private int validateGameCount(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COUNT_MESSAGE.getMessage());
        }
        return gameCount;
    }

    private void simulate(ArrayList<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = random();
            racingCar.move(randomNumber);
            this.resultView.printCarPosition(racingCar.getCurrentPosition());
        }
    }

    private int random() {
        return (int) (Math.random() * 10);
    }

    private void separateRound(int nowRound, int gameCount) {
        if (nowRound != gameCount - 1) {
            this.resultView.separateGameRound();
        }
    }

}

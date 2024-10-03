package racingcar;

import racingcar.car.Cars;
import racingcar.exception.GameException;
import racingcar.game.GameRunnable;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingCar implements GameRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingCar() {
        this.inputHandler = new ConsoleInputHandler();
        this.outputHandler = new ConsoleOutputHandler();
    }


    @Override
    public void run() {
        try {
            outputHandler.showCommentForCarNames();
            String[] carNamesFromUser = inputHandler.getCarNamesFromUser();
            outputHandler.showCommentForTrialCount();
            int trialCountFromUser = inputHandler.getTrialCountFromUser();

            racingStart(carNamesFromUser, trialCountFromUser);
        } catch (GameException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception e) {
            outputHandler.showSimpleMessage("프로그램에 문제가 생겼습니다.");
        }
    }

    private void racingStart(String[] carNames, int trialCount) {
        Cars cars = Cars.createCars(carNames);

        outputHandler.showSimpleMessage("실행 결과");
        for (int i = 0; i < trialCount; i++) {
            cars.move();
            outputHandler.showTrialResult(cars);
        }

        outputHandler.showWinnerOfRace(cars);
    }

}

package racingcar.io;

import racingcar.car.Cars;

public interface OutputHandler {

    void showCommentForCarNames();

    void showCommentForTrialCount();

    void showExceptionMessage(Exception e);

    void showSimpleMessage(String message);

    void showTrialResult(Cars cars);

    void showWinnerOfRace(Cars cars);
}

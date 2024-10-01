package racingcar.io;

import racingcar.car.Cars;

public interface OutputHandler {

    void showCommentForCarCount();

    void showCommentForTrialCount();

    void showExceptionMessage(Exception e);

    void showSimpleMessage(String message);

    void showTrialResult(Cars cars);
}

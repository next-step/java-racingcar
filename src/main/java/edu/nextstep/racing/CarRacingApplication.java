package edu.nextstep.racing;

import edu.nextstep.racing.view.InputView;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 21:03
 */
public class CarRacingApplication {

    private InputView input;

    public CarRacingApplication() {
        this.input = new InputView();
    }

    public static void main(String[] args) {
        CarRacingApplication app = new CarRacingApplication();
        int carCount = app.input.setCarNumber();
        int moveCount = app.input.setMoveNumber();
        app.start(carCount, moveCount);
    }

    public void start(int carCount, int moveCount) {
        CarRacing race = new CarRacing(carCount, moveCount);
        race.move();
    }
}

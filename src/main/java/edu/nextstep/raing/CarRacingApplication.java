package edu.nextstep.raing;

import edu.nextstep.raing.view.InputView;

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
        int[] settingNumber = app.input.setNumber();
    }
}

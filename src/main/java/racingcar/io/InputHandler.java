package racingcar.io;

import racingcar.car.CarName;

public interface InputHandler {

    CarName[] getCarNamesFromUser();

    int getTrialCountFromUser();
}

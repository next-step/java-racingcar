package racingcar;

import racingcar.control.RaceControl;
import racingcar.control.input.CarInputControl;
import racingcar.control.input.InputControl;
import racingcar.control.input.TrialInputControl;

public class Program {
    public static void main(String[] args) {
        InputControl carControl = new CarInputControl();
        InputControl trialControl = new TrialInputControl();

        int cars = carControl.integer();
        int trials = trialControl.integer();

        RaceControl raceControl = new RaceControl(cars, trials);
        raceControl.start();
    }
}

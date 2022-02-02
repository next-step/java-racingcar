package racinggame.domain;

import racinggame.exception.InputBlankException;
import racinggame.exception.NameLengthOverException;
import racinggame.view.InputView;

public class Retry {

    public static RacingCars createRacingCarsUntilValid() {
        RacingCars racingCars;

        while (true) {
            try {
                racingCars = new RacingCars(InputView.inputCarNames());
                break;
            } catch (NameLengthOverException | InputBlankException e) {
                InputView.printErrorMessage(e.getMessage());
            }
        }
        return racingCars;
    }

    public static Trial createTrialUntilValid() {
        Trial trial;

        while (true) {
            try {
                trial = new Trial(InputView.inputTrial());
                break;
            } catch (InputBlankException | NumberFormatException e) {
                InputView.printErrorMessage(e.getMessage());
            }
        }
        return trial;
    }
}

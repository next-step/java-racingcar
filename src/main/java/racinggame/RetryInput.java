package racinggame;

import racinggame.domain.RacingCars;
import racinggame.domain.Trial;
import racinggame.exception.InputBlankException;
import racinggame.exception.NameLengthOverException;
import racinggame.view.InputView;

public class RetryInput {

    public static RacingCars createRacingCarsUntilValid() {
        RacingCars racingCars;

        while (true) {
            try {
                racingCars = new RacingCars(InputView.inputCarNames());
                break;
            } catch (NameLengthOverException | InputBlankException e) {
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
        return trial;
    }
}

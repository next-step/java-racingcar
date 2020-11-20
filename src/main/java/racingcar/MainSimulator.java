package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.dto.output.RacingGameResponse;
import racingcar.view.RacingCarView;
import racingcar.dto.input.RacingCarRequest;

public class MainSimulator {

    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {

        RacingCarRequest parameter = RacingCarView.getInputValue();
        RacingGameResponse racingCarResult = racingCarController.getRacingCarResult(parameter);
        RacingCarView.printRacingResult(racingCarResult);

    }

}

package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.car.Cars;
import racingcar.view.RacingCarView;
import racingcar.view.input.RacingCarParameter;

import java.util.List;

public class MainSimulator {

    private static final RacingCarController racingCarController = new RacingCarController();
    private static final RacingCarView racingCarView = new RacingCarView();

    public static void main(String[] args) {

        RacingCarParameter racingCarParameterValue = racingCarView.getInputValue();
        List<Cars> racingCarResult = racingCarController.getRacingCarResult(racingCarParameterValue);
        racingCarView.printRacingResult(racingCarResult);

    }

}

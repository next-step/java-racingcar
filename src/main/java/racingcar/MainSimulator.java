package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.car.Cars;
import racingcar.view.RacingCarView;
import racingcar.view.input.RacingCarParameter;

import java.util.List;

public class MainSimulator {

    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {

        RacingCarParameter racingCarParameterValue = RacingCarView.getInputValue();
        List<Cars> racingCarResult = racingCarController.getRacingCarResult(racingCarParameterValue);
        RacingCarView.printRacingResult(racingCarResult);

    }

}

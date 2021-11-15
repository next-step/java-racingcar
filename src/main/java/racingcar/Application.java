package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.dto.InputDto;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String name = InputView.getCarName();
        Integer tryCount = InputView.getTryCount();

        RacingCarController racingCarController = RacingCarController.getInstance();
        racingCarController.racingGame(InputDto.of(name, tryCount));
    }

}

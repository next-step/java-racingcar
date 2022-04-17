package racingcar;

import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;

public class RacingCarGame {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        RacingCarGameService racingCarGameService = new RacingCarGameService(inputView.getCarCount(), inputView.getTryCount());
        racingCarGameService.startGame();
    }
}

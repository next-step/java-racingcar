package racingcar;

import racingcar.service.RacingGameService;

public class Application {

    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();
        racingGameService.setCarNumber();
        racingGameService.setMoveTimes();
        racingGameService.racing();
    }
}

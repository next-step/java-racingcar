package study.racing;

import study.racing.controller.RacingGameController;
import study.racing.model.rule.RandcomNumberRule;
import study.racing.service.RacingGameService;

public class Main {

    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(new RacingGameService(new RandcomNumberRule()));
        controller.start();
    }
}

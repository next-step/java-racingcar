package racingcar.view.web;

import racingcar.view.web.controller.RacingGameController;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        RacingGameController.main();
        RacingGameController.name();
        RacingGameController.game();

    }
}

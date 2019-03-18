import web.RacingGameController;

import static spark.Spark.port;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        RacingGameController racingGameController = new RacingGameController();
        racingGameController.index();
        racingGameController.name();
        racingGameController.result();
    }
}

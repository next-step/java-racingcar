package racingcar;


import java.io.IOException;
import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) throws IOException {
        RacingController racingController = new RacingController();
        racingController.run();
    }
}


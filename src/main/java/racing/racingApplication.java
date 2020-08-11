package racing;

import racing.controller.RacingController;

public class racingApplication {
    public static void main(String[] args) throws Exception {
        RacingController racingController = new RacingController();
        racingController.startRacing();
    }
}

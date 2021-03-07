package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] arg){
        RacingCarController carController = new RacingCarController();
        carController.run();
    }
}

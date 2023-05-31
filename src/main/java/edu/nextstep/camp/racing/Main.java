package edu.nextstep.camp.racing;

import edu.nextstep.camp.racing.controller.RacingController;
import edu.nextstep.camp.racing.service.RacingService;

public class Main {
    public static void main(String[] args) {
        RacingService racingService= new RacingService();
        RacingController racingController = new RacingController(racingService);

        racingController.start();
    }
}

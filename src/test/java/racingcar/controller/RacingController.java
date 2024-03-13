package racingcar.controller;

import racingcar.service.RacingService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RacingController {


    private final RacingService racingService = new RacingService();

    public RacingController() {
    }

    public void racing() {

//        makeCars(count());
        racingService.makeCars();

        int tryCount = racingService.moveCount();
        while (tryCount > 0) {
            racingService.moveCar();
            tryCount--;
            System.out.println();
        }
    }
}

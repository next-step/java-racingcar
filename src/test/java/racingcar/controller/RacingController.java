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
        racingService.makeCars(count());

        int tryCount = racingService.moveCount(count());
        while (tryCount > 0) {
            racingService.moveCar();
            tryCount--;
            System.out.println();
        }
    }

    private int count() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt <= 0) throw new IllegalArgumentException("잘못된 입력값 입니다");
        return cnt;
    }









}

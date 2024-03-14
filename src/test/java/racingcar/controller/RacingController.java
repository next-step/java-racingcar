package racingcar.controller;

import racingcar.service.RacingService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RacingController {



    private final RacingService racingService;


    public RacingController(RacingService racingService) {
        this.racingService = racingService;

    }

    public void racing() {

        racingService.makeCars(carCount());
        racingService.totalTry(moveCount());

        racingService.racing();
    }

    private int count() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt <= 0) throw new IllegalArgumentException("잘못된 입력값 입니다");
        return cnt;
    }

    public int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return count();
    }

    public int moveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return count();

    }
}

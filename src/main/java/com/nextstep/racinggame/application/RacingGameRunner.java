package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class RacingGameRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MovePolicy GAS_STATION = new RandomMovePolicy();

    private static final String CAR_DEMAND_COMMENT = "자동차 대수는 몇 대 인가요?";
    private static final String RACE_DEMAND_COMMENT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_HEADER = "\n실행 결과";

    public static void main(String[] args) {
        System.out.println(CAR_DEMAND_COMMENT);
        int carDemand = SCANNER.nextInt();
        System.out.println(RACE_DEMAND_COMMENT);
        int raceDemand = SCANNER.nextInt();

        run(carDemand, raceDemand);
    }

    private static void run(final int carDemand, final int raceDemand) {
        // TODO: 임시방편 Cars 수정 후 수정 필요
        Names names = new Names(
                Arrays.asList(new Name("test1"), new Name("test2"), new Name("test3")));
        Cars cars = Cars.of(names);

        System.out.println(RESULT_HEADER);
        for (int i = 0; i < raceDemand; i++) {
            Cars racedCars = RacingGame.race(cars, GAS_STATION);

            System.out.println(RacingGameResultDrawer.drawGameResult(racedCars));

            cars = racedCars;
        }
    }
}

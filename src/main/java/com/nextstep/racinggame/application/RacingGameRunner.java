package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.*;
import com.nextstep.racinggame.view.InputView;
import com.nextstep.racinggame.view.RacingGameResultOutputView;
import com.nextstep.racinggame.view.RacingGameWinnerOutputView;

import java.util.List;

public class RacingGameRunner {
    private static final MovePolicy RANDOM_MOVE_POLICY = new RandomMovePolicy();

    private static final String CAR_DEMAND_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_DEMAND_COMMENT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_HEADER = "\n실행 결과";

    public static void main(String[] args) {
        System.out.println(CAR_DEMAND_COMMENT);
        List<Name> names = InputView.getCarNames();

        System.out.println(RACE_DEMAND_COMMENT);
        int raceCount = InputView.getRacingCount();

        run(names, raceCount);
    }

    private static void run(final List<Name> names, final int raceDemand) {
        Cars cars = CarsFactory.createCars(names);

        System.out.println(RESULT_HEADER);
        for (int i = 0; i < raceDemand; i++) {
            Cars racedCars = cars.move(RANDOM_MOVE_POLICY);

            System.out.println(RacingGameResultOutputView.drawGameResult(racedCars));

            cars = racedCars;
        }

        Cars mostMovedCars = cars.calculateMostMovedCars();
        System.out.println(RacingGameWinnerOutputView.parseToWinnerResult(mostMovedCars));
    }
}

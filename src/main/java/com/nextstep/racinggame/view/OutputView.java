package com.nextstep.racinggame.view;

import com.nextstep.racinggame.domain.Cars;

public class OutputView {
    private static final String CAR_DEMAND_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_DEMAND_COMMENT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_HEADER = "\n실행 결과";

    public static void printCarDemandMessage() {
        System.out.println(CAR_DEMAND_COMMENT);
    }

    public static void printRaceDemandMessage() {
        System.out.println(RACE_DEMAND_COMMENT);
    }

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printGameProgress(Cars racedCars) {
        System.out.println(RacingGameResultOutputView.drawGameProgress(racedCars));
    }

    public static void printWinnerResult(Cars mostMovedCars) {
        System.out.println(RacingGameWinnerOutputView.parseToWinnerResult(mostMovedCars));
    }
}

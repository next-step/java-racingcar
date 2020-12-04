package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.*;
import com.nextstep.racinggame.view.InputView;
import com.nextstep.racinggame.view.RacingGameResultOutputView;

import java.util.Scanner;

public class RacingGameRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MovePolicy GAS_STATION = new RandomMovePolicy();

    private static final String CAR_DEMAND_COMMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_DEMAND_COMMENT = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_HEADER = "\n실행 결과";

    public static void main(String[] args) {
        System.out.println(CAR_DEMAND_COMMENT);
        String userInput = SCANNER.nextLine();
        System.out.println(RACE_DEMAND_COMMENT);
        int raceDemand = SCANNER.nextInt();

        run(userInput, raceDemand);
    }

    private static void run(final String userInput, final int raceDemand) {
        InputView inputView = new InputView(userInput);

        Cars cars = CarsFactory.createCars(inputView.parseToNames());

        System.out.println(RESULT_HEADER);
        for (int i = 0; i < raceDemand; i++) {
            Cars racedCars = RacingGame.race(cars, GAS_STATION);

            System.out.println(RacingGameResultOutputView.drawGameResult(racedCars));

            cars = racedCars;
        }
    }
}

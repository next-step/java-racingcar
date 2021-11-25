package com.rick.racing.view;

import com.rick.racing.domain.Car;
import com.rick.racing.domain.CarGroup;
import com.rick.racing.domain.CarName;
import com.rick.racing.domain.CarPosition;
import com.rick.racing.domain.CarRacingInfo;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MESSAGE_RUN_RESULT = "실행 결과";
    private static final String PROGRESS_MARK = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String FORMAT_CAR_NAME = "%s : ";
    private static final String FORMAT_WINNER_CONGRATS_MESSAGE = "%s가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void drawRoundResult(final CarGroup carGroup) {
        carGroup.getCars()
            .forEach(ResultView::drawCurrentCarStatus);
        System.out.println();
    }

    private static void drawCurrentCarStatus(final Car car) {
        System.out.printf(FORMAT_CAR_NAME, car.getName());
        CarPosition carPosition = car.getPosition();

        for (int i = 0; i < carPosition.asInt(); i++) {
            System.out.print(PROGRESS_MARK);
        }

        System.out.println();
    }

    public static void drawWinner(final CarRacingInfo racingPlayData) {
        String winnerNames = racingPlayData.getCarGroup()
            .getWinners()
            .stream()
            .map(Car::getName)
            .map(CarName::toString)
            .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.printf(FORMAT_WINNER_CONGRATS_MESSAGE, winnerNames);
    }

    public static void drawRunResultMessage() {
        System.out.println(MESSAGE_RUN_RESULT);
    }
}

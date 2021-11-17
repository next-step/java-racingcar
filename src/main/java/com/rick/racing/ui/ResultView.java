package com.rick.racing.ui;

import com.rick.racing.model.Car;
import com.rick.racing.model.CarName;
import com.rick.racing.model.CarPosition;
import com.rick.racing.model.CarRacingInfo;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MESSAGE_RUN_RESULT = "실행 결과";
    private static final String PROGRESS_MARK = "-";
    public static final String WINNER_DELIMITER = ", ";
    public static final String FORMAT_CAR_NAME = "%s : ";
    public static final String FORMAT_WINNER_CONGRATS_MESSAGE = "%s가 최종 우승했습니다.";


    public static void drawRoundResult(CarRacingInfo racingPlayData) {
        racingPlayData.cars()
            .forEach(ResultView::drawCurrentCarStatus);
        System.out.println();
    }

    private static void drawCurrentCarStatus(Car car) {
        System.out.printf(FORMAT_CAR_NAME, car.name());
        CarPosition carPosition = car.position();

        for (int i = 0; i < carPosition.asInt(); i++) {
            System.out.print(PROGRESS_MARK);
        }

        System.out.println();
    }

    public static void drawWinner(CarRacingInfo racingPlayData) {
        String csvWinners = racingPlayData.winners()
            .stream()
            .map(Car::name)
            .map(CarName::toString)
            .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.printf(FORMAT_WINNER_CONGRATS_MESSAGE, csvWinners);
    }

    public static void drawRunResultMessage() {
        System.out.println(MESSAGE_RUN_RESULT);
    }
}

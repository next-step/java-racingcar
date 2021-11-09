package com.kakao.racingcar.ui;

import com.kakao.racingcar.domain.car.Car;
import com.kakao.racingcar.history.CarHistory;
import com.kakao.racingcar.history.RacingHistory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String DASH_LINE = "-";

    public static void printRacingGame(RacingHistory racingHistory) {
        Map<Integer, List<CarHistory>> result = racingHistory.getResult();
        result.values().forEach(OutputView::printCarLine);

    }

    private static void printCarLine(List<CarHistory> carHistories) {
        for (CarHistory carHistory : carHistories) {
            System.out.println(carHistory.getUserName() + " : " + joinLine(carHistory.getPosition()));
        }
        System.out.println();
    }

    protected static String joinLine(int count) {
        return String.join("", Collections.nCopies(count, DASH_LINE));
    }

    public static void printWinner(List<String> winner) {
        String userName = String.join(", ", winner);
        System.out.println(userName + "가 최종우승했습니다.");
    }
}

package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingResult;
import util.StringUtils;

public class ResultView {
    static final String RESULT_TITLE = "\n실행 결과";
    static final String POSITION_STRING = "-";
    static final String WINNING_MESSAGE = "이(가) 최종 우승했습니다.";

    public static void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void showCarPositions(RacingResult result) {
        for(Car curCar : result.getCars()) {
            System.out.println(String.format("%s : %s", curCar.getName(), StringUtils.repeat(POSITION_STRING, curCar.getPosition())));
        }
        System.out.println();
    }

    public static void showWinners(RacingResult result) {
        System.out.println(result.getDisplayableWinnerNames() + WINNING_MESSAGE);
    }
}
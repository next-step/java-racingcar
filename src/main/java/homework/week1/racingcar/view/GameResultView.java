package homework.week1.racingcar.view;

import homework.week1.racingcar.domain.GameResult;
import homework.week1.racingcar.util.ResultStringUtil;

import java.util.List;

public class GameResultView {
    private static final String WINNER_CAR_NAME_GUIDE = "가 최종 우승했습니다.";

    public static void printRaceResultCars(GameResult gameResult) {
        gameResult.getResultCars().stream()
                .map(t -> ResultStringUtil.makeCarRaceResultMessage(t.getName(), t.getPosition()))
                .forEach(System.out::println);
        ResultStringUtil.printEmptyLine();
    }

    public static void printWinnerCars(List<String> carNames) {
        ResultStringUtil.printGuideStr(String.join(", ", carNames) + WINNER_CAR_NAME_GUIDE);
    }

}

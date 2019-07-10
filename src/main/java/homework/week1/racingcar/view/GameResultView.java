package homework.week1.racingcar.view;

import com.google.common.base.Strings;
import homework.week1.racingcar.domain.Car;
import homework.week1.racingcar.domain.GameResult;

import java.util.List;

public class GameResultView {
    private static final String WINNER_CAR_NAME_GUIDE = "가 최종 우승했습니다.";
    private static final String RUN_SYMBOL = "-";

    public static void printRaceResultCars(GameResult gameResult) {
        gameResult.getResultCars().stream()
                .map(GameResultView::makeCarRaceResultMessage)
                .forEach(System.out::println);
        printEmptyLine();
    }

    public static void printWinnerCars(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + WINNER_CAR_NAME_GUIDE);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    private static String makeCarRaceResultMessage(Car car) {
        return car.getName()  + " : " + makeCarRaceImage(car.getPosition());
    }

    private static String makeCarRaceImage(int position) {
        return Strings.repeat(RUN_SYMBOL, position);
    }
}

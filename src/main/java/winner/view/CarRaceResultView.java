package winner.view;

import winner.domain.Car;
import winner.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:22
 */
public class CarRaceResultView {

    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    public static void printCars(List<Car> cars) {
        cars.stream().forEach(car -> System.out.println(car.currentPosition()));
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String winnersText = winners.stream().collect(Collectors.joining(", "));
        System.out.println(String.format("%s%s", winnersText, WINNER_TEXT));
    }

}

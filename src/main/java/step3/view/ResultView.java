package step3.view;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Name;
import step3.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

import static step3.util.StringUtil.combined;

public class ResultView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String COLON = " : ";
    private static final String TRACKING_SYMBOL = "-";

    public static void printResultInfoMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(Cars cars) {
        printRoundResultPerCar(cars);
        System.out.println();
    }

    private static void printRoundResultPerCar(Cars cars) {
        cars.cars().stream().forEach(ResultView::printRoundResult);
    }

    private static void printRoundResult(Car car) {
        printName(car.name());
        printPosition(car.position());
        System.out.println();
    }

    private static void printName(Name name) {
        System.out.print(name.name() + COLON);
    }

    private static void printPosition(Position position) {
        System.out.print(positionText(position));
    }

    private static String positionText(Position position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position.position(); i++) {
            stringBuilder.append(TRACKING_SYMBOL);
        }

        return stringBuilder.toString();
    }

    public static void printWinner(Cars winners) {
        System.out.println(winnerText(winners.cars()));
    }

    private static String winnerText(List<Car> winners) {
        return String.format(WINNER_MESSAGE, combined(winnerNames(winners)));
    }

    private static List<String> winnerNames(List<Car> winners) {
        return winners.stream()
            .map(Car::name)
            .map(Name::name)
            .collect(Collectors.toList());
    }

}

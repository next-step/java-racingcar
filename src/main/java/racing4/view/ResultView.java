package racing4.view;

import racing4.domain.Race4Car;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void displayGameResult(List<Race4Car> cars) {
        cars.forEach(ResultView::displayGameResult);
        System.out.println();
    }

    private static void displayGameResult(Race4Car race4Car) {
        System.out.print(race4Car.getName() + " : ");
        IntStream.range(0, race4Car.getPosition())
                 .forEach(i -> System.out.print("-"));
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String formattedWinners = String.join(",", winners);
        System.out.println(String.format(WINNER_MESSAGE, formattedWinners));
    }
}

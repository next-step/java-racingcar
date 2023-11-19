package racing4.view;

import racing4.domain.Race4Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void displayExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void displayRoundResult(List<Race4Car> cars) {
        cars.forEach(ResultView::getRoundResult);
        System.out.println();
    }

    public static void displayWinner(List<Race4Car> race4Cars) {
        String formattedWinners = String.join(",", getWinnerNames(race4Cars));
        System.out.println(String.format("%s가 최종 우승했습니다.",
                                         formattedWinners));
    }

    private static void getRoundResult(Race4Car race4Car) {
        System.out.print(race4Car.getName() + " : ");
        IntStream.range(0, race4Car.getPosition())
                 .forEach(i -> System.out.print("-"));
        System.out.println();
    }

    private static List<String> getWinnerNames(List<Race4Car> race4Cars) {
        return race4Cars.stream()
                        .filter(race4Car -> race4Car.isMaxPosition(getMaxPosition(race4Cars)))
                        .map(Race4Car::getName)
                        .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Race4Car> race4Cars) {
        return race4Cars.stream()
                        .mapToInt(Race4Car::getPosition)
                        .max()
                        .orElse(0);
    }
}

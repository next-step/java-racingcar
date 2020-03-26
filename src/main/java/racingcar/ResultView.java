package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResultView {

    private static final String CAR_MOVEMENT_MARKER = "-";
    public static final String WINNER_NAME_DELIMITER = ", ";

    public static void printGameResult() {
        print("실행 결과");
    }

    private static void print(String result) {
        System.out.println(result);
    }

    public static void renderCarMovement(List<Car> cars) {
        for (Car c : cars) {
            print(c.getName() + " : " + generateMarker(c));
        }
        print("");
    }

    public static void printWinners(List<Car> cars) {
        List<Car> winners = new Cars(cars).getWinners();
        List<String> nameOfWinners = winners.stream()
                .map(Car::getName)
                .collect(toList());

        print(nameOfWinners.stream().collect(joining(WINNER_NAME_DELIMITER)) + "가 최종 우승했습니다.");
    }

    private static String generateMarker(Car c) {
        return Stream
                .generate(() -> CAR_MOVEMENT_MARKER)
                .limit(c.getPosition())
                .collect(joining());
    }
}

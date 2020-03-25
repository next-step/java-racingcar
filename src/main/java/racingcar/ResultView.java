package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    private static final String CAR_MOVEMENT_MARKER = "-";

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

    private static String generateMarker(Car c) {
        return Stream
                .generate(() -> CAR_MOVEMENT_MARKER)
                .limit(c.getPosition())
                .collect(Collectors.joining());
    }
}

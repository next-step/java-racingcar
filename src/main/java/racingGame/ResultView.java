package racingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String GAME_START_MESSAGE = "실행결과";
    public static final String CAR_DISTANCE_PATTERN = "-";
    public static final String RESULT_MESSAGE_DELIMITER = " : ";

    public static void printResult(List<Car> list) {
        List<String> resultMessages = list.stream()
                .map(ResultView::parseCarToResultMessage)
                .collect(Collectors.toList());

        for (String resultMessage : resultMessages) {
            System.out.println(resultMessage);
        }
        System.out.println();
    }

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    private static String parseIntegerToBar(int value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append(CAR_DISTANCE_PATTERN);
        }
        return sb.toString();
    }

    public static String parseCarToResultMessage(Car car) {
        return (car.getName() + RESULT_MESSAGE_DELIMITER + parseIntegerToBar(car.getDistance()));
    }
}

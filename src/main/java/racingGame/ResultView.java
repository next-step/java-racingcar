package racingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String GAME_START_MESSAGE = "실행결과";
    public static final String WINNER_PRINT_MESSAGE = "가 최종 우승했습니다.";
    public static final String CAR_DISTANCE_PATTERN = "-";
    public static final String RESULT_MESSAGE_DELIMITER = " : ";

    public static void printResult(List<Car> cars) {
        List<String> resultMessages = cars.stream()
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

    public static void printWinnerMessage(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(winner.get(0).getName());
        for (int i = 1; i < winner.size(); i++) {
            sb.append(", ").append(winner.get(i).getName());
        }
        System.out.println(sb + WINNER_PRINT_MESSAGE);
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

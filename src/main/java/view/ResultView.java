package view;

import game.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String MOVE_SIGN = "-";
    public static final String DELIMITER = " : ";
    public static final String WINNERS_DELIMITER = ", ";

    public static void print(Cars cars) {
        Map<String, Integer> positionByName = cars.positionByName();
        positionByName.forEach((name, position) -> {
            System.out.println(name + DELIMITER + convert(position));
        });
        System.out.println();
    }

    private static String convert(int position) {
        return MOVE_SIGN.repeat(position);
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(join(winnerNames) + "가 최종 우승했습니다.");
    }
    private static String join(List<String> winnerNames) {
        if (winnerNames == null || winnerNames.isEmpty()) {
            return "";
        }
        return winnerNames.stream()
                .collect(Collectors.joining(WINNERS_DELIMITER));
    }
}

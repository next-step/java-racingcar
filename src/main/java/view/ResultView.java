package view;

import game.Cars;

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

    public static void printResult(Cars cars) {
        Map<String, Integer> positionByName = cars.positionByName();
        int maxPosition = positionByName.values().stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        String winners = positionByName.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(WINNERS_DELIMITER));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

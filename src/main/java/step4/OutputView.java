package step4;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;


public class OutputView {
    private static final int SUBSTRING_START = 0;
    private static final int SUBSTRING_END = 2;
    private static final String NAME_SEPARATOR = ", ";
    private static final String LINE_BREAKER = "\n";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = "";
    private static final String PRESENT_POSITION = "-";
    private static final String GAME_START_MESSAGE = "경기 시작";
    private static final String ANNOUNCE_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void start() {
        print(GAME_START_MESSAGE);
    }

    public static void render(Result result) {
        System.out.println(result.getResult()
                .stream()
                .reduce(DELIMITER, getResultBiFunction(), String::concat));
    }

    public static String showPosition(int position) {
        return String.join(DELIMITER, Collections.nCopies(position, PRESENT_POSITION));
    }

    public static void winner(Result result) {
        int maximum = result.getMax();
        List<Car> winners = result.getWinners(maximum);
        String winner = winners.stream()
                .reduce(DELIMITER, getWinnerBiFunction(), String::concat);
        String names = winner.substring(SUBSTRING_START, winner.length() - SUBSTRING_END);
        print(names + ANNOUNCE_WINNER_MESSAGE);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static BiFunction<String, Car, String> getWinnerBiFunction() {
        return (sub, element) -> sub + element.getName() + NAME_SEPARATOR;
    }

    private static BiFunction<String, Car, String> getResultBiFunction() {
        return (sub, element) -> sub + element.getName() + SEPARATOR + showPosition(element.getPosition())  + LINE_BREAKER;
    }
}

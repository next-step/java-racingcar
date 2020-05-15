package racingcar.view;

import racingcar.Car;
import racingcar.Cars;
import racingcar.RacingGameResult;

import java.util.*;

public class ResultView {

    private static final String BANNER = "실행 결과";
    private static final String OUTPUT_CHARACTER = "-";
    private static final String COLON = " : ";

    private static final String DELIMITER = ",";

    private static final String SUFFIX_WINNER_PRINT = "가 최종 우승하였습니다.";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBanner() {
        System.out.println(BANNER);
    }

    public static void startPosition(Cars cars){
        cars.getCars().sort(Comparator.comparing(Car::getName));

        cars.getCars()
                .forEach(car -> System.out.println(car.getName() + COLON + convertStringPosition(car.getPosition())));
        System.out.println();
    }

    public static void printResult(int gameRoundCount, RacingGameResult racingGameResult){
        Map<String, List<Integer>> results = racingGameResult.getResults();
        for (int i = 0; i < gameRoundCount; i++) {
            printCarPositionPerRound(results, i);
        }
    }

    public static void printWinner(List<String> winners){
        StringJoiner joiner = new StringJoiner(DELIMITER);
        winners.forEach(joiner::add);
        System.out.println(joiner.toString() + SUFFIX_WINNER_PRINT);
    }

    private static void printCarPositionPerRound(Map<String, List<Integer>> results, int round) {
        results.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    String carName = entry.getKey();
                    int position = entry.getValue().get(round);
                    System.out.println(carName + COLON + convertStringPosition(position));
                });
        System.out.println();
    }

    private static String convertStringPosition(int position) {
        String result = OUTPUT_CHARACTER;
        for (int i = 0; i < position; i++) {
            result += OUTPUT_CHARACTER;
        }
        return result;
    }
}

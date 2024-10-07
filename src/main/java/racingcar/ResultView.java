package racingcar;

import java.util.List;

public class ResultView {

    private static final String symbol = "-";

    public static void printRaceResults(List<List<String>> raceResults) {
        System.out.println("실행결과");
        for (List<String> roundResult : raceResults) {
            for (String result : roundResult) {
                System.out.println(result);
            }
            System.out.println();
        }
    }

    public static String generateCarStatusResult(Car car) {
        return car.getName() + " : " + car.getStatus(symbol);
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }


}

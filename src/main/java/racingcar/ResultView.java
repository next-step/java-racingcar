package racingcar;

import java.util.List;

public class ResultView {

    private static final String symbol = "-";

    public static void printRaceResults(List<List<Car>> raceResults) {
        System.out.println("실행결과");
        for (List<Car> roundResult : raceResults) {
            for (Car car : roundResult) {
                System.out.println(generateCarStatusResult(car));
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

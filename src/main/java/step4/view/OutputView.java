package step4.view;

import step4.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    public static final String BANNER_STRING = "실행 결과";
    public static final String DASH_STRING = "-";
    public static final String WINNER_COMMENT = "가 최종 우승했습니다.";

    public static String getDashDistance(int value) {
        // 현재 이 String을 Thread Safe로 할 의미가 없으므로, StringBuilder로 수정
        StringBuilder dashString = new StringBuilder();
        // Java 11에서는 DASH_STRING.REPEAT(value)로 치환 가능
        return dashString.append(String.join("", Collections.nCopies(value, DASH_STRING))).toString();
    }

    public static void showResultOfGame(List<Car> cars, int trials) {
        System.out.println(BANNER_STRING);
        for (int loop = 1; loop <= trials; loop++) {
            showDistanceOfEachGameSet(cars, loop);
            System.out.println();
        }
        showWinner(cars, trials);
    }

    private static void showWinner(List<Car> cars, int maximum) {
        List<String> winnerMembers = new ArrayList<>();
        int maxScore = getMaximumScoreFromParticipants(cars);
        for (Car car : cars) {
            winnerMembers.add(findWinnerPlayer(maximum, maxScore, car));
        }
        printWinnersFromParticipants(winnerMembers);
    }

    private static void printWinnersFromParticipants(List<String> winnerMembers) {
        System.out.printf("%s" + WINNER_COMMENT + "%n",
                winnerMembers.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining(", "))
        );
    }

    private static int getMaximumScoreFromParticipants(List<Car> cars) {
        OptionalInt maxScore = cars.stream()
                .flatMap(l -> l.getAllRecords().stream())
                .distinct()
                .mapToInt(i -> Integer.parseInt(String.valueOf(i)))
                .max();
        return maxScore.getAsInt();
    }

    private static String findWinnerPlayer(int maximum, int maxScore, Car car) {
        if (car.getScore(maximum) == maxScore) {
            return car.getCarName();
        }
        return null;
    }

    private static void showDistanceOfEachGameSet(List<Car> members, int trials) {
        for (Car member : members) {
            System.out.println(member.getCarName() + ": " + getDashDistance(member.getScore(trials)));
        }
    }
}

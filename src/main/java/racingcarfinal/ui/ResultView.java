package racingcarfinal.ui;

import racingcarfinal.domain.Car;
import racingcarfinal.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printResultsMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printOneRoundResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getName().getValue() + " : " + changeToCharacter(car.getPosition().getIntValue(), '-'));
        });
        System.out.println();
    }

    private static String changeToCharacter(int count, char character) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(winner -> winner.getName().getValue())
                .collect(Collectors.joining(","));
        System.out.printf(WINNER_MESSAGE, winnerNames);
    }

}

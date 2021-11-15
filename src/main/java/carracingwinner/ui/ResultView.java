package carracingwinner.ui;

import carracingwinner.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public void printResultsMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printOneRoundResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getName() + " : " + changeToCharacter(car.getPosition(), '-'));
        });
        System.out.println();
    }

    public String changeToCharacter(int count, char character) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

    public void printWinners(List<String> winners) {
        String winner = winners.stream()
                .collect(Collectors.joining(","));
        System.out.printf(WINNER_MESSAGE, winner);
    }
}

package racingcar.view;

import racingcar.domain.CarState;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PATTERN = "-";

    public void printResult(List<List<CarState>> results) {
        System.out.println("실행 결과");

        printAllResult(results);
        printLastResult(results.get(results.size() - 1));
        System.out.println();
    }

    private void printAllResult(List<List<CarState>> results) {
        for (List<CarState> result : results) {
            printCarState(result);
        }
    }

    private void printLastResult(List<CarState> carStates) {
        printCarState(carStates);
    }

    private void printCarState(List<CarState> result) {
        for (CarState car : result) {
            System.out.println(String.join(" : ", car.getName(), PATTERN.repeat(car.getPosition())));
        }
        System.out.println();
    }

    public void printWinners(List<CarState> winners) {
        System.out.println(getWinnerNames(winners) + "가 최종 우승했습니다.");
    }

    private String getWinnerNames(List<CarState> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarState::getName)
                .collect(Collectors.toList());

        return String.join(", ", winnerNames);
    }
}

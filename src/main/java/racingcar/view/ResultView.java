package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PATTERN = "-";

    public void printResult(List<List<CarDto>> results) {
        System.out.println("실행 결과");

        printAllResult(results);
        printLastResult(results.get(results.size() - 1));
        System.out.println();
    }

    private void printAllResult(List<List<CarDto>> results) {
        for (List<CarDto> result : results) {
            printCarState(result);
        }
    }

    private void printLastResult(List<CarDto> carDtos) {
        printCarState(carDtos);
    }

    private void printCarState(List<CarDto> result) {
        for (CarDto car : result) {
            System.out.println(String.join(" : ", car.getName(), PATTERN.repeat(car.getPosition())));
        }
        System.out.println();
    }

    public void printWinners(List<CarDto> winners) {
        System.out.println(getWinnerNames(winners) + "가 최종 우승했습니다.");
    }

    private String getWinnerNames(List<CarDto> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());

        return String.join(", ", winnerNames);
    }
}

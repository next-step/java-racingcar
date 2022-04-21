package view;

import domain.Car;
import domain.CarRacingResultDto;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String RESULT_FORM = "%s : %s";
    private static final String POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ",";
    private static final ResultView resultView = new ResultView();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return resultView;
    }

    public void printRacingResult(CarRacingResultDto racingResult) {
        System.out.println(RESULT_MESSAGE);
        racingResult.getRacingResults().forEach(this::printEachAttempt);
        System.out.print(NEW_LINE);

        String result = String.format(WINNERS_MESSAGE, racingResult.getWinners().stream().map(Car::getName).collect(Collectors.joining(DELIMITER)));
        System.out.println(result);
    }

    private void printEachAttempt(Map<String, Integer> positions) {
        positions.keySet().forEach(carName -> printCarPosition(carName, positions.get(carName)));
        System.out.print(NEW_LINE);
    }

    private void printCarPosition(String carName, int attemptCount) {
        String carPosition = String.format(RESULT_FORM, carName, POSITION_BAR.repeat(attemptCount));
        System.out.println(carPosition);
    }
}

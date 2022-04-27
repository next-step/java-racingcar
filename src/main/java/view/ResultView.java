package view;

import domain.CarRacingResultDto;
import domain.dto.RacingResults;
import domain.dto.WinnerResult;

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

        String result = String.format(WINNERS_MESSAGE, racingResult.getWinners().stream().map(WinnerResult::getCarName).collect(Collectors.joining(DELIMITER)));
        System.out.println(result);
    }

    private void printEachAttempt(RacingResults results) {
        results.getRacingResults().forEach(racingResult -> printCarPosition(racingResult.getCarName(), racingResult.getPosition()));
        System.out.print(NEW_LINE);
    }

    private void printCarPosition(String carName, int attemptCount) {
        String carPosition = String.format(RESULT_FORM, carName, POSITION_BAR.repeat(attemptCount));
        System.out.println(carPosition);
    }
}

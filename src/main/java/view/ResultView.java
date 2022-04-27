package view;

import domain.CarRacingResultDto;
import domain.dto.RacingResults;
import domain.dto.WinnerResult;

import java.util.stream.Collectors;

public class ResultView {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String RESULT_HEADER_MESSAGE = "실행 결과";
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
        addMessageToResult(RESULT_HEADER_MESSAGE);
        racingResult.getRacingResults()
                .forEach(this::addEachAttemptToResult);

        String winnerMessage = String.format(WINNERS_MESSAGE, findWinners(racingResult));
        addMessageToResult(winnerMessage);

        printTotalResultMessage();
    }

    private String findWinners(CarRacingResultDto racingResult) {
        return racingResult.getWinners().stream()
                .map(WinnerResult::getCarName)
                .collect(Collectors.joining(DELIMITER));
    }

    private void addMessageToResult(String message) {
        stringBuilder.append(message).append(NEW_LINE);
    }

    private void addEachAttemptToResult(RacingResults results) {
        results.getRacingResults().forEach(racingResult -> addCarPosition(racingResult.getCarName(), racingResult.getPosition()));
        stringBuilder.append(NEW_LINE);
    }

    private void addCarPosition(String carName, int attemptCount) {
        String carPosition = String.format(RESULT_FORM, carName, POSITION_BAR.repeat(attemptCount));
        addMessageToResult(carPosition);
    }

    private void printTotalResultMessage() {
        System.out.println(stringBuilder);
        initStringBuilder();
    }

    private void initStringBuilder() {
        stringBuilder.setLength(0);
    }
}

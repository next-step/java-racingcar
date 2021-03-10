package racing.view;

import racing.domain.ReadonlyCar;
import racing.dto.RacingReport;
import racing.dto.RoundResult;
import racing.io.OutputDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String EMPTY_CHAR = "\0";
    private static final String NAME_DELIMITER = ", ";

    private final OutputDriver driver;
    private final String carSymbol;

    public ResultView(OutputDriver driver, String carSymbol) {
        this.driver = driver;
        this.carSymbol = carSymbol;
    }

    public void printRacingReport(RacingReport racingReport) {
        driver.println("실행 결과");
        printRacingHistory(racingReport.getRoundResults());
        printWinners(racingReport.getWinners());
    }

    private void printWinners(List<String> winners) {
        driver.println(String.join(NAME_DELIMITER, winners) + "가 최종 우승했습니다.");
    }

    private void printRacingHistory(List<RoundResult> roundResults) {
        StringBuilder stringBuilder = new StringBuilder();

        roundResults.forEach(roundResult -> {
            List<String> racingStates = makeRacingState(roundResult);
            stringBuilder.append(String.join(NEW_LINE, racingStates));
            stringBuilder.append(NEW_LINE);
            stringBuilder.append(NEW_LINE);
        });

        driver.print(stringBuilder.toString());
    }

    private List<String> makeRacingState(RoundResult roundResult) {
        return roundResult.getCarList()
                          .stream()
                          .map(this::makeRacingStateOfUser)
                          .collect(Collectors.toList());
    }

    private String makeRacingStateOfUser(ReadonlyCar car) {
        return String.format("%s : %s", car.getName(), generateTrack(car.getLocation()));
    }

    private String generateTrack(int location) {
        return new String(new char[location]).replace(EMPTY_CHAR, this.carSymbol);
    }

}

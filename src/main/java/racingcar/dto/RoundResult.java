package racingcar.dto;

import racingcar.domain.CarName;
import racingcar.domain.CarResult;

import java.util.List;
import java.util.stream.Collectors;

public record RoundResult(List<CarResult> carResults) {
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    public RoundResult {
        carResults = List.copyOf(carResults);
    }

    public List<CarName> getWinners() {
        int maxPosition = carResults.stream()
                .mapToInt(CarResult::position)
                .max()
                .orElseThrow();
        return carResults.stream()
                .filter(result -> result.position() == maxPosition)
                .map(CarResult::name)
                .toList();
    }

    public String formatProgress() {
        return carResults.stream()
                .map(RoundResult::formatProgress)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String formatWinners() {
        return getWinners().stream()
                .map(CarName::value)
                .collect(Collectors.joining(WINNER_DELIMITER)) + WINNER_SUFFIX;
    }

    private static String formatProgress(CarResult carResult) {
        return carResult.name().value() + NAME_POSITION_DELIMITER + POSITION_MARK.repeat(carResult.position());
    }
}

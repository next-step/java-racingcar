package step3.view.dto;

import step3.model.EachTryResult;
import step3.model.GameResult;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultDto {

    private static final String LINE_BREAK_PER_EACH_TRY = "\n----------\n";
    private static final String LINE_BREAK = "\n";

    private final List<EachTryResultDto> eachTryResultDtos;
    private final String winners;

    private GameResultDto(GameResult gameResult) {
        this.eachTryResultDtos = initEachTryResultDtos(gameResult.getEachTryResults());
        this.winners = initWinners(gameResult.getWinnerNames());
    }

    private List<EachTryResultDto> initEachTryResultDtos(List<EachTryResult> eachTryResults) {
        return eachTryResults.stream()
                .map(EachTryResultDto::new)
                .collect(Collectors.toList());
    }

    private String initWinners(List<String> winnerNames) {
        return String.join(", ", winnerNames);
    }

    public static GameResultDto of(GameResult gameResult) {
        return new GameResultDto(gameResult);
    }

    @Override
    public String toString() {
        String result = eachTryResultDtos.stream()
                .map(EachTryResultDto::toString)
                .collect(Collectors.joining(LINE_BREAK_PER_EACH_TRY));
        return result + LINE_BREAK + getWinnerMessage();
    }

    private String getWinnerMessage() {
        return this.winners + "가 최종 우승했습니다.";
    }
}

package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.dto.RacingCarDto;

public class OutputView {
    public static final String MOVE_DISTANCE_EXPRESSION = "-";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String EXECUTION_RESULT = "실행 결과";

    public void printGameResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printGameResult(List<RacingCarDto> racingCarDtos) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (RacingCarDto racingCarDto : racingCarDtos) {
            stringJoiner.add(racingCarDto.getCarName() + " : " +
                    MOVE_DISTANCE_EXPRESSION.repeat(Math.toIntExact(racingCarDto.getPosition())));
        }
        System.out.print(stringJoiner.add("\n"));
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerFormatter = new StringJoiner(",");
        for (String winner : winners) {
            winnerFormatter.add(winner);
        }
        System.out.printf(WINNER_MESSAGE, winnerFormatter);
    }
}

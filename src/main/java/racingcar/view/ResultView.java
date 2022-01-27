package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import racingcar.domain.dto.OutputDto;

import static racingcar.common.SystemMessage.FINAL_WINNERS_INFO;
import static racingcar.common.SystemMessage.NO_WINNER_INFO;

public class ResultView {

    private static final int ZERO = 0;
    private static final String COMMA = ",";

    private StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static ResultView instance() {
        return new ResultView();
    }

    public String announceWinner(final List<String> judgeWinners) {
        stringBuilder.setLength(ZERO);

        if (judgeWinners.size() == ZERO) {
            return NO_WINNER_INFO;
        }
        stringBuilder.append(FINAL_WINNERS_INFO);
        stringBuilder.append(String.join(COMMA, judgeWinners));
        return stringBuilder.toString();
    }

    public void announceRacingDetails(final List<OutputDto> outputDtos) {
        for (OutputDto dto : outputDtos) {
            System.out.println(dto.getCurrentCarStatement());
        }
    }

}

package racingcar.view;

import java.util.List;
import racingcar.domain.CarStateInRace;
import racingcar.domain.MovingResult;
import racingcar.domain.RacingResult;

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

    public String announceWinner(final RacingResult result) {
        List<String> judgeWinners = result.getResult();
        stringBuilder.setLength(ZERO);

        if (judgeWinners.size() == ZERO) {
            return NO_WINNER_INFO;
        }
        stringBuilder.append(FINAL_WINNERS_INFO);
        stringBuilder.append(String.join(COMMA, judgeWinners));
        return stringBuilder.toString();
    }

    public void announceRacingDetails(final MovingResult movingResult) {
        List<CarStateInRace> carStateInRaces = movingResult.getCarsState();
        for (CarStateInRace state : carStateInRaces) {
            System.out.println(state.getCurrentCarStatement());
        }
    }

}

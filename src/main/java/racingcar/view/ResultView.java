package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarStateInRace;
import racingcar.domain.MovingResult;
import racingcar.domain.RacingResult;

import static racingcar.common.SystemMessage.FINAL_WINNERS_INFO;
import static racingcar.common.SystemMessage.NO_WINNER_INFO;

public class ResultView {

    private static final int ZERO = 0;
    private static final String COMMA = ",";
    private final static String STEP = "-";

    private final StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static ResultView instance() {
        return new ResultView();
    }

    public void announceWinner(final RacingResult result) {
        List<String> judgeWinners = result.getResult();
        stringBuilder.setLength(ZERO);

        if (judgeWinners.size() == ZERO) {
            System.out.println(NO_WINNER_INFO);
            return;
        }
        stringBuilder.append(FINAL_WINNERS_INFO);
        stringBuilder.append(String.join(COMMA, judgeWinners));
        System.out.println(stringBuilder);
    }

    public void announceRacingDetails(final MovingResult movingResult) {
        List<CarStateInRace> carStateInRaces = movingResult.getCarsState();
        for (CarStateInRace state : carStateInRaces) {
            System.out.println(state.getCurrentCarStatement());
        }
    }

    public void convertCurrentCarStatement(final CarStateInRace carStateInRace) {
        stringBuilder.setLength(ZERO);
        Car raceCar = carStateInRace.getCar();

        stringBuilder
            .append(raceCar.getName())
            .append(": ");

        for (int step = ZERO; step < raceCar.getStep(); step++) {
            stringBuilder.append(STEP);
        }
        carStateInRace.storeCurrentCarState(stringBuilder.toString());
    }

}

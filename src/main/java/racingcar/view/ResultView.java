package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.common.SystemMessage.FINAL_WINNERS_INFO;
import static racingcar.common.SystemMessage.NO_WINNER_INFO;

public class ResultView {

    private static final int ZERO = 0;
    private static final String STEP = "-";
    private static final String COMMA = ",";

    private StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static ResultView instance() {
        return new ResultView();
    }

    public void announceCurrentStatement(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + carPosition(car));
            stringBuilder.setLength(ZERO);
        }
    }

    private String carPosition(final Car car) {
        for (int step = ZERO; step < car.getStep(); step++) {
            stringBuilder.append(STEP);
        }
        return stringBuilder.toString();
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

}

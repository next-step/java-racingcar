package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

public class ConsoleResultView implements ResultView {
    private static final String PROGRESS_BAR = "-";

    @Override
    public void print(List<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (RacingCar car : cars) {
            car.repeatAsMoveCount(() -> stringBuilder.append(PROGRESS_BAR));
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}

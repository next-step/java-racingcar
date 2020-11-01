package racingcar.resultview;

import racingcar.domain.RacingCar;

import java.util.List;

public class ConsoleResultView implements ResultView {
    private static final String PROGRESS_BAR = "-";
    private static final String NAME_PUNCTUATION_MARK  = ": ";

    @Override
    public void print(List<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (RacingCar car : cars) {
            car.labelName((name) -> stringBuilder.append(name).append(NAME_PUNCTUATION_MARK));
            car.repeatAsMoveCount(() -> stringBuilder.append(PROGRESS_BAR));
            stringBuilder.append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }
}

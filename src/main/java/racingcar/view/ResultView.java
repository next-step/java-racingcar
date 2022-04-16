package racingcar.view;

import racingcar.dto.RoundResult;
import racingcar.model.CarName;
import racingcar.model.Distance;

import java.util.List;

public final class ResultView {
    private static final String START_TEXT = "실행 결과";
    private static final String START_LINE = " : ";
    private static final String CAR_STATE = "-";
    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(List<RoundResult> roundResults) {
        printStartText();
        for (RoundResult roundResult : roundResults) {
            printRoundResult(roundResult.getCarsCount(), roundResult.getCarNames(), roundResult.getStates());
        }
    }

    private static void printStartText() {
        System.out.println(START_TEXT);
    }

    public static void printRoundResult(int carsCount, List<CarName> carNames, List<Distance> states) {
        for (int i = 0; i < carsCount; i++) {
            printCarInfo(carNames.get(i), states.get(i));
        }
    }

    private static void printCarInfo(CarName carName, Distance state) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName.value() + START_LINE);
        for (int j = 0; j < state.value(); j++) {
            sb.append(CAR_STATE);
        }
        sb.append(NEW_LINE);
        System.out.println(sb);
    }
}

package racingcar.view;

import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.RoundResult;

public class ResultView {

    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String PATH_STRING = "-";
    public void printTitle() {
        System.out.println("\n" + RESULT_DESCRIPTION);
    }

    public void printResult(RoundResult roundResult) {
        for(var car: roundResult.getCarStats()) {
            System.out.println(makeFormattedString(car.getName(), car.getPosition()));
        }
        printNewLine();
    }

    private String makeFormattedString(Name name, Position position) {
        return String.format("%s : %s", name.getValue(), PATH_STRING.repeat(position.getValue()));
    }

    private void printNewLine() {
        System.out.println();
    }
}

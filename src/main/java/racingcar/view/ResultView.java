package racingcar.view;

import java.util.List;

import racingcar.domain.RoundResult;

public class ResultView {

    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String PATH_STRING = "-";
    public void printTitle() {
        System.out.println("\n" + RESULT_DESCRIPTION);
    }

    public void printResult(RoundResult roundResult) {
        for(var position: roundResult.getPositions()) {
            System.out.println(PATH_STRING.repeat(position));
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }
}

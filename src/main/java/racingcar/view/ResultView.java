package racingcar.view;

import java.util.List;

public class ResultView {

    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String PATH_STRING = "-";
    public void printTitle() {
        System.out.println("\n" + RESULT_DESCRIPTION);
    }

    public void printResult(List<Integer> result) {
        for(var position: result) {
            System.out.println(PATH_STRING.repeat(position));
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }
}

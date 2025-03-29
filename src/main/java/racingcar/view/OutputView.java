package racingcar.view;

import java.util.List;

import static java.lang.System.out;

public class OutputView {

    public void printResult(List<Integer> results) {
        results.forEach(result -> out.println("_".repeat(result)));
        out.println();
    }

    public void printStartMessage() {
        out.println("실행 결과");
    }

}

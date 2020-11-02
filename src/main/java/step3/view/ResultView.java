package step3.view;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class ResultView {
    private final String SYMBOL = "-";
    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void show(List<List<Integer>> results) {
        output.println("실행 결과");
        results.forEach(resultAtStep -> {
            resultAtStep.forEach(position -> {
                output.println(String.join("", Collections.nCopies(position, SYMBOL)));
            });
            output.println();
        });
    }
}

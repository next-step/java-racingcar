package step3.view;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class ResultView {
    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void show(List<List<Integer>> results) {
        output.println("실행 결과");
        for (List<Integer> resultAtStep : results) {
            for (Integer position : resultAtStep) {
                output.println(String.join("", Collections.nCopies(position, "-")));
            }
            output.println();
        }
    }
}

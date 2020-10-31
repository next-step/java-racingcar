package step3.view;

import java.io.PrintWriter;
import java.util.List;

public class ResultView {
    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void show(List<String> result) {
        output.println("실행 결과");
        for (int i = 0; i < result.size(); i++) {
            output.print(result.get(i));
        }
    }
}

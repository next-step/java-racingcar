package step3.view;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ResultView {

    private static final String DISPLAY_CHARACTER = "-";

    public void printResult(List<Integer> result) {
        String displayResult = result.stream()
                .map(DISPLAY_CHARACTER::repeat)
                .collect(Collectors.joining("\n"));
        show(displayResult);
    }

    private void show(String output) {
        out.println(output);
    }
}

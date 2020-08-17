package racing.ui;

import racing.core.Trial;

import java.util.List;

public class ResultView {

    private List<Trial> trials;

    public ResultView(List<Trial> trials) {
        this.trials = trials;
    }

    public void printResult() {
        for (Trial each : trials) {
            System.out.println(each);
        }
    }
}

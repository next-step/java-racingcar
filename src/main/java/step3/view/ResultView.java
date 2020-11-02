package step3.view;

import step3.strategy.PrintMarkStrategy;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final ResultView resultView = new ResultView();
    private final StringBuilder racingProgress = new StringBuilder();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return resultView;
    }

    private void draw(List<Integer> list, PrintMarkStrategy strategy) {
        list.forEach(progress -> {
            racingProgress.append(String.valueOf(strategy.getPrintMark()).repeat(Math.max(0, progress)));
            racingProgress.append(System.lineSeparator());
        });
        racingProgress.append(System.lineSeparator());
    }

    public void viewAll(Map<Integer, List<Integer>> history, PrintMarkStrategy strategy) {
        if (racingProgress.length() > 0) {
            racingProgress.delete(0, racingProgress.length());
        }
        for (List<Integer> value : history.values()) {
            draw(value, strategy);
        }
        System.out.println(racingProgress.toString());
    }
}

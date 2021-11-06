package racinggame;

import java.util.List;

public class ResultViews {

    List<ResultView> results;

    public ResultViews(List<ResultView> results) {
        this.results = results;
    }

    public void showResult() {
        System.out.println("실행 결과");
        for (ResultView result : results) {
            result.showAdvanceStatus();
        }
    }
}

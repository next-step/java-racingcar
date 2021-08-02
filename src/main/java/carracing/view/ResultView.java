package carracing.view;

import carracing.domain.RaceResult;
import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void showResult(List<RaceResult> results) {
        for (RaceResult result : results) {
            System.out.println(result.raceResult());
        }
    }

}

package carracing.step3;

import java.util.List;

public class ResultView {

    public void printResults(List<Integer> result, int playCount) {
        if (playCount == 0) {
            System.out.println("실행 결과");
        }
        for (int trace : result) {
            System.out.println("-".repeat(trace));
        }
        System.out.println();
    }
}

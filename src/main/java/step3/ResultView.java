package step3;

import java.util.List;

public class ResultView {

    public void printScore(List<Integer> scoreList, int carCout) {
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println("-".repeat(scoreList.get(i)));
            if (i % carCout == 0) System.out.println("");
        }
    }
}

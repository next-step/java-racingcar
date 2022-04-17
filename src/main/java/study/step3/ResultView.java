package study.step3;

import static study.step3.RacingcarGame.resultList;

public class ResultView {

    public void print() {
        for (int position : resultList) {
            for (int j = 0; j < position; j++) {
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }
}

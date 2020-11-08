package racingcar.step3.view;

import racingcar.step3.common.Consts;

/**
 * Created : 2020-11-02 오전 8:25
 * Developer : Seo
 */
public class ResultView {

    public void print(int distance) {
        System.out.println((gridDistance(distance)));
    }

    private String gridDistance(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printTurnOver() {
        System.out.println();
    }

    public void printResultTitle() {
        System.out.println(Consts.RESULT);
    }
}

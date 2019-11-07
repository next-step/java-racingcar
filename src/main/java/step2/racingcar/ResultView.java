/*
 * Description : 자동차경주에서 주행결과를 보여주는 기능을 담당
 */

package step2.racingcar;

public class ResultView {

    public static void printCarTrace(int[] carPositionArr, int targetPosition) {
        for (int j = 0; j < carPositionArr[targetPosition]; j++) { //차가 움직인 거리만큼 표시함
            System.out.print("-");
        }
    }
}

/*
 * 각 라운드별 자동차 경주의 실행 결과를 출력하는 UI 클래스
 * */
package step3;

import java.util.List;

public class ResultView {

    public void showResultMessage() {
        System.out.println();
        System.out.println(Constants.MSG_RESULT);
    }

    public void printEachCar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Constants.MOVE_MARK);
        }
        System.out.println();
    }

}

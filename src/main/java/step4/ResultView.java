/*
 * 각 라운드별 자동차 경주의 실행 결과를 출력하는 UI 클래스
 * */
package step4;

import java.util.List;

public class ResultView {

    /**
     * 실행 결과 메시지를 출력하는 메소드
     */
    public void showResultMessage() {
        System.out.println();
        System.out.println(Constants.MSG_RESULT);
    }


    /**
     * 각 라운드 실행결과를 출력하는 메소드
     * */
    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            printEachCar(car);
        }
        System.out.println();
    }

    /**
     * 매 라운드마다 자동차들이 이동한 상태를 출력하는 메소드
     */
    public String printEachCar(Car car) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Constants.MOVE_MARK);
            result.append(Constants.MOVE_MARK);
        }

        System.out.println();

        return result.toString();
    }

}


package racingcar_step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void showAllStates(List<Car> cars, int tryNum) {
        System.out.println("\n실행결과");

        for (int i = 0; i < tryNum; i++) {
            showEachState(cars, i);
        }
    }

    private static void showEachState(List<Car> cars, int tryIdx) {
        cars.forEach(car -> {
            StringBuilder sb = makeTrace(car, tryIdx);
            System.out.println(car.getName() + " : " + sb);
        });

        System.out.println("");
    }

    private static StringBuilder makeTrace(Car car, int tryIdx) {
        StringBuilder trace = new StringBuilder();
        List<Integer> positionHistory = car.getPositionHistory();
        for (int i = 0; i < positionHistory.get(tryIdx); i++) {
            trace.append('-');
        }
        return trace;
    }

    public static void showWinner(String winnerList) {
        System.out.println(winnerList + "가 최종 우승했습니다.");
    }

}

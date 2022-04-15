package racingcar_step3;

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
            System.out.println(sb);
        });
        System.out.println("");
    }

    private static StringBuilder makeTrace(Car car, int tryIdx) {
        StringBuilder sb = new StringBuilder();
        List<Integer> positionHistory = car.getPositionHistory();
        for (int i = 0; i < positionHistory.get(tryIdx); i++) {
            sb.append('-');
        }
        return sb;
    }
}

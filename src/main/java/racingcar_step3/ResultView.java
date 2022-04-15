package racingcar_step3;

import java.util.List;

public class ResultView {

    public static void showAllStates(List<Car> cars, int tryNum) {
        System.out.println("\n실행결과");
        for (int i = 0; i < tryNum; i++) {
            showEachState(cars, i);
        }
    }

    private static void showEachState(List<Car> cars, int i) {
        for (Car car : cars) {
            StringBuilder sb = makeTrace(i, car);
            System.out.println(sb);
        }
        System.out.println("");
    }

    private static StringBuilder makeTrace(int i, Car car) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < car.getPositionHistory().get(i); j++) {
            sb.append('-');
        }
        return sb;
    }
}

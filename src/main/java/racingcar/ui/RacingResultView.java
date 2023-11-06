package racingcar.ui;

import racingcar.core.Car;

import java.util.List;

public class RacingResultView {
    private static final String CAR_PRINT = "-";

    public void resultView(List<Car> cars) {
        System.out.println();
        for (Car car : cars) {
            StringBuffer sb = new StringBuffer();
            printCarPosition(car, sb);
        }
    }

    private static void printCarPosition(Car car, StringBuffer sb) {
        for (int i = 0; i < car.getForwardCnt(); i++) {
            sb.append(CAR_PRINT);
        }
        System.out.print(sb);
        sb.setLength(0);
        System.out.println();
    }
}

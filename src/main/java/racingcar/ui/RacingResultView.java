package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingResultView {

    private static final String CAR_PRINT = "-";

    public static void printResult(Cars cars) {
        System.out.println();
        for (Car car : cars.carList()) {
            StringBuffer sb = new StringBuffer();
            printCarName(car);
            printCarPosition(car, sb);
        }
    }

    private static void printCarPosition(Car car, StringBuffer sb) {
        for (int i = 0; i < car.forwardCnt(); i++) {
            sb.append(CAR_PRINT);
        }
        System.out.print(sb);
        sb.setLength(0);
        System.out.println();
    }

    private static void printCarName(Car car) {
        System.out.print(car.carName() + " : ");
    }

    public static void printRacingWinner(Cars cars) {
        List<String> winner = cars.maxPositionCars();
        System.out.println();
        System.out.println(String.join(", ", winner)+" 가 최종 우승했습니다.");
    }
}

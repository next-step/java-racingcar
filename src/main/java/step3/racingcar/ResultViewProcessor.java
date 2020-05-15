package step3.racingcar;

import java.util.List;

public class ResultViewProcessor {

    private static final String RESULT_MEESAGE = "실행 결과";
    private static boolean isFirst = true;

    private ResultViewProcessor() {
    }

    public static void printResult(List<Car> cars) {
        int carCounts = cars.size();
        if (isFirst == true) {
            System.out.println(RESULT_MEESAGE);
            isFirst = false;
        }
        for (int i = 0; i < carCounts; i++) {
            printCurrentPosition(cars.get(i));
        }
        System.out.println();
    }

    private static void printCurrentPosition(Car car) {
        int currentPosition = car.getPosition();
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

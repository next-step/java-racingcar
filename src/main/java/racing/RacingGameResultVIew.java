package racing;

import java.util.List;

public class RacingGameResultVIew {

    private final static String PRINT_CAR_PISITION = "-";

    public static void racingResultView(RacingGameResult rgr) {
        System.out.println("실행 결과");

        // 운행횟수반복
        for (int time = 0; time < rgr.getTime(); time++) {
            printCars(rgr.getCars(), time);
            System.out.println();
        }
    }

    // 자동차 전체출력
    public static void printCars(List<Car> cars, int time) {
        for (Car car : cars) {
            printCars(car.getMoveValues().get(time));
        }
    }

    // 자동차 위치기반 출력
    public static void printCars(int moveCount) {
        String outputValue = "";

        for (int i = 0; i < moveCount; i++) {
            outputValue += PRINT_CAR_PISITION;
        }
        System.out.println(outputValue);
    }
}

package racingcar;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarsPosition(RacingCar[] cars) {
        for (int i = 0; i < cars.length; i++) {
            printCarPosition(cars[i]);
        }
        System.out.println();
    }

    private static void printCarPosition(RacingCar cars) {
        for (int i = 0; i < cars.getCarPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

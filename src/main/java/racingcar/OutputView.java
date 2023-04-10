package racingcar;

public class OutputView {

    public static void printExecutionResult() {
        System.out.println("\n실행 결과");
    }
    public static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        System.out.println("-".repeat(position));
    }
}

package step3;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";

    public static void printResultStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + makeProgress(car.getMoveDistance()));
        }
        System.out.println();
    }

    private static String makeProgress(int moveDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moveDistance; i++) {
            stringBuilder.append(PROGRESS_BAR);
        }
        return String.valueOf(stringBuilder);
    }

    public static void printWinner(String winners) {

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

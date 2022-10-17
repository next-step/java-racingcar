package view;

import domain.Car;
import java.util.List;

public class ResultView {
    private static final String PLAY_RESULT = "실행 결과";
    private static final String HIPEN = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";

    public void printResult() {
        System.out.println("\n" + PLAY_RESULT);
    }

    public void printPlayResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        int position = car.getIntValuePosition();
        System.out.print(car.getCarName());
        System.out.print(COLON);
        for (int i = 0; i < position; i++) {
            System.out.print(HIPEN);
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(COMMA, winners) + "가 최종 우승했습니다.");
    }
}

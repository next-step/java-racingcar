package step3;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String carStatus = car.getName() + " : " + "-".repeat(car.getTrace());
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() -1) {
                System.out.print(", ");
            }
        }
    }
}

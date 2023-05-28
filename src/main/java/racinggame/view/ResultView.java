package racinggame.view;

import racinggame.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String carStatus = car.getName().getValue() + " : " + "-".repeat(car.getTrace().getValue());
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName().getValue());
            if (i != winners.size() -1) {
                System.out.print(", ");
            }
        }
    }
}

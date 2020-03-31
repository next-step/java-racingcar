package racingGame.view;

import racingGame.domain.Car;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> allCars) {
        for (Car car : allCars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printPosition(int position) {
        for (int roundPosition = 0; roundPosition < position; roundPosition++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다");
    }
}

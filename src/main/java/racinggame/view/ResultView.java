package racinggame.view;

import racinggame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void printWinner(List<Car> winners) {
        StringBuilder winnerResult = new StringBuilder();
        winnerResult.append(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
        winnerResult.append("가 최종 우승했습니다");
        System.out.println(winnerResult);
    }
}

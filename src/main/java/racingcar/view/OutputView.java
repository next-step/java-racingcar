package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printHistories(List<List<Car>> histories) {
        histories.forEach(OutputView::printCars);
    }

    private static void printCars(List<Car> cars) {
        cars.forEach(OutputView::printCar);
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + convertPosition(car.getDistance()));
    }

    private static String convertPosition(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append('-');
        }
        return builder.toString();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner: winners) {
            winnerNames.add(winner.getName());
        }
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winnerNames));
    }
}

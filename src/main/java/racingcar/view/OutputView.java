package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printHistories(List<List<Car>> histories) {
        histories.forEach(OutputView::printCars);
    }

    private static void printCars(List<Car> cars) {
        System.out.println();
        cars.forEach(OutputView::printCar);
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
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i != (winners.size() - 1)) {
                winnerNames.append(", ");
            }
        }

        System.out.print("최종 우승자: ");
        System.out.println(winnerNames);
    }
}

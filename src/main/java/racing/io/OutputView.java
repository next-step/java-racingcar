package racing.io;

import racing.model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void view(List<Car> cars) {
        cars.forEach(OutputView::printForCount);
        System.out.println();
    }

    private static void printForCount(Car car) {
        System.out.println(car.getName() + ":" + new String(new char[car.getPosition()]).replace("\0", "-"));
    }

    public static void showWinner(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getPosition));
        int winnerPosition = cars.get(0).getPosition();
        List<Car> sortedCars = cars.stream().filter(e -> e.getPosition() == winnerPosition).collect(Collectors.toList());
        String winnerNames = "";
        for (Car e : sortedCars) {
            winnerNames = winnerNames.concat(e.getName() + ",");
        }
        System.out.println(winnerNames + "가 최종 우승 하였습니다.");
    }
}

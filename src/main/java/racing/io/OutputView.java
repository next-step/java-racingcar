package racing.io;

import racing.model.Car;

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
        String name = buildWinnerNames(cars);
        System.out.println(name + "가 최종 우승 하였습니다.");
    }


    private static String buildWinnerNames(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> winnerCars = getWinnerCars(cars, maxPosition);
        return collectWinnersName(winnerCars);
    }

    private static String collectWinnersName(List<Car> winnerCars) {
        String winnerNames = "";
        for (Car e : winnerCars) winnerNames = winnerNames.concat(e.getName() + ",");
        return winnerNames.substring(0, winnerNames.length() - 1);
    }

    private static List<Car> getWinnerCars(List<Car> cars, int maxPosition) {
        return cars.stream().filter(e -> e.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow(NullPointerException::new);
    }
}

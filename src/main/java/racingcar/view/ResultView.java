package racingcar.view;

import java.util.List;
import racingcar.domain.vehicle.Car;
import racingcar.domain.vehicle.Cars;
import racingcar.domain.vehicle.Names;

public class ResultView {

    private static final char PRINT_FLAG = '-';

    public static void pirntProgress(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car ->
            System.out.println(car.getName() + " : " + getDistanceString(car.getDistanceValue())));
    }

    private static String getDistanceString(int distance) {
        StringBuilder distanceString = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            distanceString.append(PRINT_FLAG);
        }

        return distanceString.toString();
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printWinners(Cars cars) {
        Names winnerNames = cars.getWinnerNames();

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}

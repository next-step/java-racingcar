package racingcargame.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.Car;
import racingcargame.domain.vehicle.Cars;
import racingcargame.domain.vehicle.WinnerCars;

public class ResultView {

    private static final char PRINT_FLAG = '-';

    public static void pirntProgress(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(ResultView::printCar);
        ResultView.println("");
    }

    private static void printCar(Car car) {
        System.out.println(car.getName().getValue() + " : " + getDistanceString(car.getDistance()));
    }

    private static String getDistanceString(Distance distance) {
        StringBuilder distanceString = new StringBuilder();

        for (int i = 0; i < distance.getValue(); i++) {
            distanceString.append(PRINT_FLAG);
        }

        return distanceString.toString();
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printWinners(Cars cars) {
        WinnerCars winners = cars.getWinners();
        String winnerNames = winners.getNames()
            .stream()
            .map(Name::getValue)
            .collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}

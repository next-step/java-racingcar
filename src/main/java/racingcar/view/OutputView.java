package racingcar.view;

import racingcar.car.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class OutputView {
    public static void printCarStatus(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder track = new StringBuilder();
            track.append(car.getName()).append(" : ");
            for(int i=1; i <= car.getStatus(); i++) {
                track.append("-");
            }
            out.println(track);
        });
    }

    public static int getWinnerStatus(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getStatus))
                .get()
                .getStatus();
    }

    public static void printRacingWinner(List<Car> cars, int maxStatus) {
        String winnerMessage = cars.stream()
                                .filter(car -> car.getStatus() == maxStatus)
                                .map(Car::getName)
                                .collect(Collectors.joining(", "));
        out.println(winnerMessage + "(이)가 최종 우승했습니다.");
    }

    public static void resultView(List<Car> cars) {
        out.println("실행 결과");
        int maxStatus = getWinnerStatus(cars);
        printRacingWinner(cars, maxStatus);
    }
}

package racing.ui;

import racing.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showCurrentPosition(Car car) {
        System.out.print(car.name() + " : ");
        for (int i = 0; i < car.position().position(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void showWinners(List<Car> cars) {
        List<String> names = cars.stream().map(c -> c.name()).collect(Collectors.toList());
        System.out.println(names.toString() + "가 최종 우승했습니다.");
    }
}

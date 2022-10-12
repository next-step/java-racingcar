package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String Bar = "-";

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printBar);
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
        System.out.printf("%s가 최종 우승했습니다.",
                String.join(", ", carNames));
    }

    private static void printBar(Car car) {
        System.out.printf("%s : ", car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(Bar);
        }
        System.out.println();
    }


}

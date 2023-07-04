package racing.io;

import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class Viewer {

    public void printBeforeRacing(List<Car> cars) {
        System.out.println("실행 결과");
        printCars(cars);
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String result = winners.stream()
                                .map(Car::getName)
                                .collect(Collectors.joining(", "));
        System.out.println(result + "가 최종 우승했습니다.");
    }

}

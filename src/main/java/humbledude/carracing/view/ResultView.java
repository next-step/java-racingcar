package humbledude.carracing.view;

import humbledude.carracing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    public void printHeader() {
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names + "가 최종 우승했습니다.");
    }

    private void printCarPosition(Car car) {
        System.out.printf("%5s : ", car.getName());
        IntStream.range(0, car.getPosition())
                .forEach(i -> System.out.print("-"));
    }
}

package step4_winner.view;

import step4_winner.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResultHeader() {
        System.out.print("실행 결과\n");
    }

    public void displayRaceResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())));
        System.out.println();
    }

    public void printFinalWinner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalStateException("List is empty "));

        String winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

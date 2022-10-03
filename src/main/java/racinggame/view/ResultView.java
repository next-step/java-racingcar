package racinggame.view;

import racinggame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResultMessage() {
        System.out.println("실행 결과");
    }
    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStatus()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(names + " 최종 우승했습니다.");
    }
}

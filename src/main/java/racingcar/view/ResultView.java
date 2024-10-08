package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public void printMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getDistance()));
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        List<Car> winners = cars.getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}

package step5.racingcar3.view;

import java.util.Scanner;
import step5.racingcar3.domain.Car;
import step5.racingcar3.domain.CarList;

public class ResultView {

    private final static Scanner scanner = new Scanner(System.in);

    public void showResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showCarResult(Car car) {
        System.out.println(car.name().value() + " : " + "-".repeat(car.position().value()));
    }

    public void showCarListResult(CarList cars) {
        for (Car car : cars.value()) {
            showCarResult(car);
        }
        System.out.println();
    }

    public void showWinnersResult(CarList winners) {
        System.out.println(
            winners.value().stream().map(car -> car.name().value()).reduce((a, b) -> a + ", " + b).orElse("")
                + "가 최종 우승했습니다.");
    }

}

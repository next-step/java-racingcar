package step5.racingcar3.view;

import java.util.Scanner;
import java.util.stream.Collectors;
import step5.racingcar3.domain.Car;

public class ResultView {

    private final static Scanner scanner = new Scanner(System.in);

    public void showCarResult(Car car) {
        System.out.println(car.name().value() + " : " + "-".repeat(car.position().value()));
    }

}

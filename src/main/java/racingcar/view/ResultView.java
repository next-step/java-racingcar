package racingcar.view;

import racingcar.Car;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DASH = "-";

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRace(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCarName() + " : " + DASH.repeat(car.getPosition()) + "\n");
        }
        System.out.println(sb);
    }

    public static void printResult(List<Car> cars) {
        System.out.println(cars.stream().map(n -> n.getCarName()).collect(Collectors.joining(",")));
    }
}

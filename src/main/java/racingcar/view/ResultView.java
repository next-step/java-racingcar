package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DASH = "-";

    private ResultView() {}

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
        System.out.println(cars
                .stream()
                .map(n -> n.getCarName())
                .collect(Collectors.joining(","))
                +"가 최종 우승했습니다."
        );
    }
}

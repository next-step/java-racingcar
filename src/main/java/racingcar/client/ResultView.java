package racingcar.client;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String POSITION_DASH = "-";
    private static final String SEPARATE_COLON = " : ";

    public static void show(String message) {
        System.out.println(message);
    }

    public static void showGameResultTitle() {
        show("실행 결과");
    }

    public static void showWinner(List<Car> cars) {
        String winners = cars.stream().map(car -> car.getName()).collect(Collectors.joining(", "));

        show(winners + "가 최종 우승했습니다.");
    }

    public static void showResult(Cars cars) {
        cars.getCars().forEach(car -> show(car.getName() + SEPARATE_COLON + POSITION_DASH.repeat(car.getPosition())));
        System.out.println();
    }
}

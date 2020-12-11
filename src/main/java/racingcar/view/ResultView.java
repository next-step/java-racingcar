package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final String MOVE_COUNT_VIEW = "-";

    public static void readyPrint() {
        System.out.println("\n실행결과");
    }

    public static void print(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> makeLocationView(car.getLocation()));
        System.out.println();
    }

    private static void makeLocationView(int location) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, location).forEach(i -> stringBuilder.append(MOVE_COUNT_VIEW));
        System.out.println(stringBuilder);
    }
}
package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class ResultView {
    private static final String MOVE_COUNT_VIEW = "-";
    private static final int INITIAL_LOCATION = 1;

    public static void readyPrint(Cars cars) {
        out.println("\n실행결과");

        cars.getCars().forEach(car -> makeLocationView(car.getName(), INITIAL_LOCATION));
        out.println();
    }

    public static void print(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> makeLocationView(car.getName(), car.getLocation()));
        out.println();
    }

    private static void makeLocationView(String carName, int location) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName).append(" : ");
        IntStream.range(0, location).forEach(i -> stringBuilder.append(MOVE_COUNT_VIEW));
        out.println(stringBuilder);
    }

    public static void winnersPrint(Cars cars) {
        out.println(cars.getWinnerCarNames() + "가 최종 우승했습니다.");
    }
}
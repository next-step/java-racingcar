package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class ResultView {
    public static void printResult(Cars cars) {
        List<Car> carPosition = cars.getCars();
        for (Car car : carPosition) {
            System.out.println(printHyphen(car.getPosition()));
        }
    }

    public static String printHyphen(int position) {
        StringJoiner joiner = new StringJoiner("-");
        IntStream hyphen = IntStream.rangeClosed(1, position);
        hyphen.forEach(s -> joiner.add(""));

        return joiner.toString();
    }
}

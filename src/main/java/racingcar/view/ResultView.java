package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printHyphen(car.getPosition()));
        }
    }
    public static String printHyphen(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

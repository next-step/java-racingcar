package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String POSITION_MARK = "_";

    public static void print(List<Car> cars) {

        for (Car car : cars) {
            print(makePositionMark(car.getPosition()));
        }
        System.out.println();
    }

    private static void print(String mark) {
        System.out.println(mark);
    }

    private static String makePositionMark(int position) {
        StringBuilder mark = new StringBuilder();
        for (int i = 0; i < position; i++) {
            mark.append(POSITION_MARK);
        }
        return mark.toString();
    }
}

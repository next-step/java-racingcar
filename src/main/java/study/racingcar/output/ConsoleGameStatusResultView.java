package study.racingcar.output;

import study.racingcar.model.Car;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ConsoleGameStatusResultView implements ResultView {
    private static final String POSITION_TEXT = "-";

    @Override
    public void printInit() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void print(List<Car> cars) {
        for (Car car : cars) {
            this.print(car);
        }

        System.out.println();
    }

    private void print(Car car) {
        System.out.println(convertPositionToString(car));
    }

    private String convertPositionToString(Car car) {
        final StringBuilder sb = new StringBuilder();

        int movedDistance = car.getPosition();
        while (movedDistance-- > 0) {
            sb.append(POSITION_TEXT);
        }

        return sb.toString();
    }
}

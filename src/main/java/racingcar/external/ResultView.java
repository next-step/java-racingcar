package racingcar.external;

import racingcar.model.Car;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView implements Output {

    private static final String MOVE_DASH = "-";

    @Override
    public void out(String s) {
        System.out.println(s);
    }

    public void out(Car car) {
        out(getMoveDash(car.getPosition()));
    }

    public String getMoveDash(int position) {
        return Stream.generate(() -> MOVE_DASH)
                .limit(position)
                .collect(joining());
    }
}

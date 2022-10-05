package racing.ui;

import java.util.StringJoiner;
import racing.domain.Car;

public class ResultViewImpl implements ResultView {

    private static final String BEGIN_TEXT = "실행 결과";
    private static final String DISTANCE_DELIMETER = "-";
    private static final String DELIMETER = " : ";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    @Override
    public void start() {
        System.out.println(BEGIN_TEXT);
    }

    @Override
    public void print(Car car) {
        StringJoiner stringJoiner = new StringJoiner(DELIMETER)
            .add(car.getName())
            .add(DISTANCE_DELIMETER.repeat(car.getDistance()));

        System.out.println(stringJoiner.toString());
    }

    @Override
    public void enter() {
        System.out.println();
    }

    @Override
    public void winner(String winner) {
        System.out.println(winner + WINNER_TEXT);
    }

}

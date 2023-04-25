package carracing.view;

import carracing.Car;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    private static final String MOVE_MARK = "-";

    public String print(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(MOVE_MARK);
        }
        return builder.toString();
    }

    public String printWinner(List<Car> cars) {
        StringJoiner joiner = new StringJoiner(",", "", "가 최종 우승했습니다.");
        for (Car car : cars) {
            joiner.add(car.getName());
        }
        return joiner.toString();
    }
}

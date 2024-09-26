package racinggame.ui;

import racinggame.car.Car;

import java.util.List;

import static racinggame.ui.MessageConstants.POSITION_GRAPH;
import static racinggame.ui.MessageConstants.RESULT_PROMPT;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("view class");
    }

    public static void promptResult(final List<Car> cars) {
        System.out.println(RESULT_PROMPT);
        for (final var car : cars) {
            System.out.println(getPositionGraph(car));
        }
    }

    private static String getPositionGraph(final Car car) {
        final var position = car.getPosition();
        return POSITION_GRAPH.repeat(position);
    }

}

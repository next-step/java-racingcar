package racingcar.view;

import racingcar.Car;

import java.util.List;


public class ResultView {

    public static final String DEFAULT_MARKER = "-";
    public static final String PLACE_HOLDER = " ";

    public void printCurrentRacingProgress(List<Car> cars) {
        StringBuilder currentProgress = new StringBuilder();

        for (Car car : cars) {
            String trace = car.getTrace(DEFAULT_MARKER);
            if (trace.isBlank()) {
                trace = PLACE_HOLDER;
            }
            currentProgress.append(trace)
                    .append("\n");
        }

        System.out.println(currentProgress);
    }
}

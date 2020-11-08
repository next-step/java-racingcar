package racingcar.external;

import racingcar.model.Cars;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String MOVE_DASH = "-";
    private static final String RACE_TREM = "********************";

    public static void output(OuputChannel outputChnnel, Cars cars) {
        for (int position : cars.getPositions()) {
            outputChnnel.out(getMoveDash(position));
        }
        outputChnnel.out(RACE_TREM);
    }

    public static String getMoveDash(int position) {
        return Stream.generate(() -> MOVE_DASH)
                .limit(position)
                .collect(joining());
    }
}

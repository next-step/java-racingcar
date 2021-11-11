package domain;

import java.util.stream.Collectors;

public class Winner {
    private static final String MAX_NUMBER_ERROR_MESSAGE = "error : MAX 값을 찾을수 없습니다.";
    private static final String COMMA = ", ";

    private Winner() {
    }

    public static String winnerName(CarRaceGroup carRaceGroup) {
        int max = positionMax(carRaceGroup);

        return carRaceGroup.getCarRaceGroup()
                .stream()
                .filter(i -> i.getPosition() == max)
                .map(i -> i.getCarName())
                .sorted()
                .collect(Collectors.joining(COMMA));
    }

    public static int positionMax(CarRaceGroup carRaceGroup) {
        return carRaceGroup.getCarRaceGroup()
                .stream()
                .mapToInt(i -> i.getPosition())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(MAX_NUMBER_ERROR_MESSAGE));
    }
}

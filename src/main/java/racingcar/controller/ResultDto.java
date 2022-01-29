package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.PlayerName;

public class ResultDto {

    private static final String DELIMITER = ": ";
    private static final String DISTANCE_CHAR = "-";

    private final PlayerName name;
    private final int position;

    public ResultDto(final Car car) {
        this.name = car.name();
        this.position = car.distance();
    }

    public String currentStatus() {
        return name.get() + DELIMITER + getDistanceBar();
    }

    public String name() {
        return name.get();
    }

    private String getDistanceBar() {
        StringBuilder sb = new StringBuilder();
        for (int size = 0; size < position; size++) {
            sb.append(DISTANCE_CHAR);
        }
        return sb.toString();
    }

}

package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

public class ResultDto {

    private static final String POSITION_MARK = "-";
    private static final String CONNECTION_FORMAT = ": ";

    private final Name carName;
    private final int position;

    public ResultDto(final Car car) {
        this.carName = car.name();
        this.position = car.position();
    }

    public String getCurrentStatus() {
        return carName + CONNECTION_FORMAT + parsePosition();
    }

    public String name() {
        return carName.getName();
    }

    private String parsePosition() {
        StringBuilder parsedPosition = new StringBuilder();
        for (int size = 0 ; size < position; size++) {
            parsedPosition.append(POSITION_MARK);
        }
        return parsedPosition.toString();
    }
}

package racingcar.util;

import racingcar.domain.Car;

public class ResultDto {
    private static final String DISPLAY_UNIT = "-";
    private static final String CONNECTION_FORMAT = " : ";

    private final String carName;
    private final int position;

    public ResultDto(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public String getResult() {
        return carName + CONNECTION_FORMAT + parsePosition();
    }

    private String parsePosition() {
        StringBuilder positionBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBuilder.append(DISPLAY_UNIT);
        }
        return positionBuilder.toString();
    }

}

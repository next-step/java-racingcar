package racingcar.controller.dto;

import racingcar.model.entity.Car;

public class OutputDTO {

    private static final String DELIMITER = ": ";
    private static final String NEW_LINE = "\n";
    private static final int NUMBER_ZERO = 0;
    private static final String DASH_SIGH = "-";
    private Car car;

    public OutputDTO(final Car car) {
        this.car = car;
    }

    public String getCarName() {
        return this.car.getName();
    }

    public String carStatementMessage() {
        return car.getName() + DELIMITER + carPosition(car) + NEW_LINE;
    }

    private String carPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = NUMBER_ZERO; i < car.getStep(); i++) {
            stringBuilder.append(DASH_SIGH);
        }

        return stringBuilder.toString();
    }

}

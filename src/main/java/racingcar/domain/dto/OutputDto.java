package racingcar.domain.dto;

import racingcar.domain.Car;

public class OutputDto {

    private final static String STEP = "-";
    private final static int ZERO = 0;

    private String currentCarStatement;
    private final Car car;
    private StringBuilder stringBuilder = new StringBuilder();

    public OutputDto(final Car car) {
        this.car = car;
    }

    public void convertCurrentCarStatement() {
        stringBuilder.append(car.getName() + ": ");
        for (int step = ZERO; step < car.getStep(); step++) {
            stringBuilder.append(STEP);
        }
        currentCarStatement = stringBuilder.toString();
    }

    public String getCurrentCarStatement() {
        return currentCarStatement;
    }
}

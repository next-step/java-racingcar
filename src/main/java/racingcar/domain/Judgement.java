package racingcar.domain;

import java.util.List;

import static racingcar.common.SystemMessage.FINAL_WINNERS_INFO;
import static racingcar.common.SystemMessage.NO_WINNER_INFO;

public class Judgement {

    private static final int ZERO = 0;
    private static final String STEP = "-";
    private static final String COMMA = ",";

    private StringBuilder stringBuilder = new StringBuilder();

    private Judgement() {
    }

    public static Judgement instance() {
        return new Judgement();
    }

    public String judge(final List<Car> cars) {
        stringBuilder.setLength(ZERO);
        int max = maxDriveLength(cars);

        if (max == ZERO) {
            stringBuilder.append(NO_WINNER_INFO);
            return stringBuilder.toString();
        }

        stringBuilder.append(FINAL_WINNERS_INFO);

        for (Car car : cars) {
            if (max == car.getStep()) {
                stringBuilder.append(car.getName());
                stringBuilder.append(COMMA);
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));

        return stringBuilder.toString();
    }

    private int maxDriveLength(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getStep)
                .max()
                .getAsInt();
    }

    private String carPosition(final Car car) {
        for (int step = ZERO; step < car.getStep(); step++) {
            stringBuilder.append(STEP);
        }
        return stringBuilder.toString();
    }

    public void carsStatement(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + carPosition(car));
            stringBuilder.setLength(ZERO);
        }
    }

}

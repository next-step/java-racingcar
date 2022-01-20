package racingcar.domain;

import java.util.List;

import static racingcar.common.SystemMessage.FINAL_WINNERS_INFO;

public class Judgement {

    private static final int ZERO = 0;

    public void judge(final List<Car> cars) {
        int max = maxDriveLength(cars);

        for (Car car : cars) {
            if (max == car.getStep()) {
                System.out.println(FINAL_WINNERS_INFO + car.getName());
            }
        }
    }

    private int maxDriveLength(List<Car> cars) {
        return cars.stream().map(car -> car.getStep())
                .mapToInt(length -> Integer.valueOf(length))
                .max()
                .getAsInt();
    }

    private String carPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int step = ZERO; step < car.getStep(); step++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    public void carsStatement(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + carPosition(car));
        }
    }
}

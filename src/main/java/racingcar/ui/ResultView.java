package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

    private final static String CAR_POSITION_STRING = "-";

    private final StringBuilder snapshot = new StringBuilder();

    public void appendSnapshot(Cars cars) {
        append(cars);
    }

    public void printCarRaceResult() {
        System.out.println("실행 결과");
        System.out.println(this.snapshot);
    }

    private void append(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.get()) {
            String carPosition = CAR_POSITION_STRING.repeat(car.getDistance().get());
            stringBuilder.append(carPosition).append("\n");
        }

        this.snapshot.append(stringBuilder).append("\n");
    }

}

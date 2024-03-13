package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Names;

import java.text.MessageFormat;

public class ResultView {

    private static final String CAR_POSITION_STRING = "-";

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
            stringBuilder.append(getPrintFormat(car)).append("\n");
        }

        this.snapshot.append(stringBuilder).append("\n");
    }

    private String getPrintFormat(Car car) {
        return MessageFormat.format("{0} : {1}"
                , car.getName().get(), CAR_POSITION_STRING.repeat(car.getDistance().get()));
    }

    public void printWinnerNames(Names names) {
        System.out.println(MessageFormat.format("{0}가 최종 우승했습니다.", names));
    }
}

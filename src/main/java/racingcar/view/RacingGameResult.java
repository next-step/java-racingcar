package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private static final String MOVEMENT_MARK = "-";
    public static final String NEW_LINE = "\n";

    List<String> records = new ArrayList<>();
    private Cars winners;

    public void record(Cars cars) {
        records.add(createStringRecord(cars));
    }

    private String createStringRecord(Cars cars) {
        StringBuilder record = new StringBuilder();

        cars.getElements()
            .stream()
            .map(this::createCarInfo)
            .forEach(record::append);

        return record.toString();
    }

    private String createCarInfo(Car car) {
        return car.name() + " : " + createMovementMark(car);
    }

    private String createMovementMark(Car car) {
        return MOVEMENT_MARK.repeat(car.positionValue()) + NEW_LINE;
    }

    public String getWinMessage() {
        List<String> winnerNames = getWinnerNames();
        return String.join(", ", winnerNames) + "가 최종 우승했습니다.";
    }

    private List<String> getWinnerNames() {
        return winners.getElements()
                .stream()
                .map(Car::name)
                .collect(Collectors.toList());
    }

    public List<String> records() {
        return Collections.unmodifiableList(records);
    }

    public void winner(Cars winners) {
        this.winners = winners;
    }
}

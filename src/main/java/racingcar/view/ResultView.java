package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

public class ResultView {

    private static final int START_FROM_INDEX = 1;
    private static final String DASH = "-";
    private static final String RACING_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "%s 가 최종 우승했습니다.";
    private static final String EMPTY = "";

    private final Cars cars;

    public ResultView(Cars cars) {
        this.cars = cars;
    }

    public void outputGameResult() {
        System.out.println("실행 결과");
        for (int i = START_FROM_INDEX; i <= cars.getTryCountTotal(); i++) {
            outputCarHistory(i);
            System.out.println();
        }
        outputWinners();
    }

    private void outputCarHistory(int i) {
        for (Car car : cars.getCars()) {
            String name = car.getName();
            int count = (int) car.getHistorySuccessCount(i);
            String move = String.join(EMPTY, Collections.nCopies(count, this.DASH));

            System.out.println(String.format(RACING_FORMAT, name, move));
        }
    }

    private void outputWinners() {
        List<String> names = this.getNames(cars.getWinners());
        System.out.println(String.format(WINNER_FORMAT, names));
    }

    private List<String> getNames(Cars winners) {
        return winners.getCars().stream()
            .map(Car::getName)
            .collect(Collectors
                .toCollection(ArrayList::new)
            );
    }
}

package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.ResultDto;
import racingcar.domain.model.Car;

public class ResultView {

    private static final int START_FROM_INDEX = 1;
    private static final String DASH = "-";
    private static final String EMPTY = "";
    private static final String RACING_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "%s 가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void outputGameResult(ResultDto resultDto) {
        System.out.println("실행 결과");
        for (int i = START_FROM_INDEX; i <= resultDto.getTryCountTotal(); i++) {
            outputCarHistory(resultDto.getCars(), i);
            System.out.println();
        }
        outputWinners(resultDto.getWinners());
    }

    private static void outputCarHistory(List<Car> cars, int toIndex) {
        for (Car car : cars) {
            String name = car.getName();
            int count = (int) car.getHistorySuccessCount(toIndex);
            String move = String.join(EMPTY, Collections.nCopies(count, DASH));

            System.out.println(String.format(RACING_FORMAT, name, move));
        }
    }

    private static void outputWinners(List<Car> cars) {
        List<String> names = getNames(cars);
        System.out.println(String.format(WINNER_FORMAT, names));
    }

    private static List<String> getNames(List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors
                .toCollection(ArrayList::new));
    }
}

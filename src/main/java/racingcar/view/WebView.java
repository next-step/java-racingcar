package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WebView {
    public static String getWinnersString(List<Car> winners) {
        return winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.joining(","));
    }
}

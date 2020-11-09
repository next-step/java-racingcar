package step5.client.worker.interfaces.render;

import step5.client.worker.domain.Car;
import step5.client.worker.domain.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerResultViewRender implements ViewRender {
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    private final List<String> winnerNames;

    public WinnerResultViewRender(final List<Car> winners) {
        this.winnerNames = winners.stream()
                .map(Car::getName)
                .map(CarName::getValue)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public String render() {
        return String.join(",", winnerNames) + WINNER_ANNOUNCEMENT;
    }
}

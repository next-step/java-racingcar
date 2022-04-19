package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Histories {

    private final List<History> histories;

    public Histories() {
        histories = new ArrayList<>();
    }

    public void add(History history) {
        histories.add(history);
    }

    public List<History> getHistories() {
        return histories;
    }

    public List<Car> findWinners() {
        History finalHistory = getFinalRoundHistory();
        int maxPosition = getMaxPosition(finalHistory);
        return finalHistory.getCars()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private History getFinalRoundHistory() {
        return histories.get(histories.size() - 1);
    }

    private int getMaxPosition(History history) {
        Comparator<Car> carComparator = Comparator.comparingInt(Car::getPosition);
        return history.getCars()
                .stream()
                .max(carComparator)
                .get()
                .getPosition();
    }
}

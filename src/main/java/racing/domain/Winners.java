package racing.domain;

import racing.util.StringUtil;

import java.util.*;

public class Winners implements Iterable<Car> {
    private static final String WINNER_DELIMITER = ",";

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        return getWinners(cars);
    }

    private static Winners getWinners(Cars cars) {
        int maxPosition = cars.maxPosition();
        List<Car> winners = new ArrayList<>();

        cars.forEach(car -> {
            if (car.samePosition(maxPosition)) {
                winners.add(car);
            }
        });

        return new Winners(winners);
    }

    @Override
    public Iterator<Car> iterator() {
        return winners.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            StringUtil.addDelimiterToStringBuilder(stringBuilder, WINNER_DELIMITER);
            stringBuilder.append(winner.getName());
        }

        return stringBuilder.toString();
    }
}

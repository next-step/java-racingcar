package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Winners {
    private static final String STR_NO_WINNERS = "우승자 없음";
    private final List<Car> winners;

    Winners(List<Car> winners) {
        this.winners = winners;
    }

    Winners() {
        this(new ArrayList<Car>());
    }

    public String toString() {
        StringBuilder winnerNames = new StringBuilder();
        Iterator<Car> it = winners.iterator();

        if (it.hasNext() == false) {
            return STR_NO_WINNERS;
        }

        winnerNames.append(it.next().getNameInString());
        while (it.hasNext()) {
            winnerNames.append(", " + it.next().getNameInString());
        }

        winnerNames.append(" 우승!");

        return winnerNames.toString();
    }

    boolean contains(Object o) {
        if (o instanceof Car == false) {
            return false;
        }

        boolean result = false;
        Car element = (Car) o;
        for (Car winner : winners) {
            result |= winner.equals(element);
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Winners == false) {
            return false;
        }

        Winners compared = (Winners) o;
        if (winners.size() != compared.winners.size()) {
            return false;
        }

        boolean result = true;
        for (Car car : compared.winners) {
            result &= contains(car);
        }

        return result;
    }
}

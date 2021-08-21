package racingcar.domain;

import java.util.Iterator;
import java.util.List;

public class Winners {
    static final String STR_NO_WINNERS = "우승자 없음";
    private final List<Car> winners;

    Winners(List<Car> winners) {
        this.winners = winners;
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
}

package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<Name> winners;

    private Winners(List<Name> winners) {
        this.winners = winners;
    }

    public static Winners find(Cars cars) {
        return new Winners(cars.findSameLocationCarNames(cars.findMaxLocation()));
    }

    public List<Name> getWinners() {
        return winners;
    }
}

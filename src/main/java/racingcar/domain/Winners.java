package racingcar.domain;

import java.util.List;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }


    public List<Car> showWinners() {
        return winners;
    }

}

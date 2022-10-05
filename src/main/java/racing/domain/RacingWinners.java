package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingWinners {
    private List<Car> winner;

    public RacingWinners(List<Car> cars) {
        this.winner = cars;
    }

    public List<String> getWinnersName() {
        List<String> names = new ArrayList<>();
        for (Car car : winner) {
            names.add(car.getName());
        }
        return names;
    }


}

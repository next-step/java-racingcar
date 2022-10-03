package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingWinner {
    private List<Car> winner;

    public RacingWinner(List<Car> cars) {
        this.winner = cars;
    }

    public String getWinnerName() {
        List<String> names = new ArrayList<>();
        for (Car car : winner) {
            names.add(car.getName());
        }
        return join(names);
    }

    public String join(List<String> names){
        return String.join(",", names);
    }
}

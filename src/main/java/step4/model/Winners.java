package step4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners = new ArrayList<>();

    public void addWinners(Car car) {

        if (winners.isEmpty()) {
            winners.add(car);
            return;
        }

        if (winners.get(0).getMoving().getDistance() == car.getMoving().getDistance()) {
            winners.add(car);
            return;
        }

        if (winners.get(0).getMoving().getDistance() < car.getMoving().getDistance()) {
            winners.clear();
            winners.add(car);
        }
    }

    public String getWinnerNames() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(","));
    }
}

package racinggame.domain.winner;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;
import racinggame.domain.winner.Winner;

public class Winners {

    private final List<Winner> winnerList = new ArrayList<>();

    public Winners(final Cars cars, final int maxLocation) {
        for (Car car : cars.getCars()) {
            if (car.getLocation() == maxLocation) {
                winnerList.add(new Winner(car.getCarName()));
            }
        }
    }

    public List<Winner> getWinners() {
        return new ArrayList<>(winnerList);
    }

}

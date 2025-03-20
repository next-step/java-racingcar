package step3.game.domain.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

    private final Set<Car> cars = new HashSet<>();

    private Players() {}

    public Players(Set<Car> cars) {
        this.cars.addAll(cars);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public List<String> finalResult() {
        int maxDistance = getMaxDistance();
        return getWinners(maxDistance);
    }

    private List<String> getWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }
}

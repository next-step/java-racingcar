package car.step3;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private int max_location;
    private List<String> winners = new ArrayList<>();

    public List<String> findWinner(List<Car> cars) {
        for (Car car : cars) {
            addWinner(car);
        }
        return this.winners;
    }

    private void addWinner(Car car) {
        if(car.location() >= this.max_location) {
            this.max_location = car.location();
            this.winners.add(car.name());
        }
    }
}

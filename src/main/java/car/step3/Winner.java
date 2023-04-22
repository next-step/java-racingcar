package car.step3;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private int maxLocation;
    private List<String> winners = new ArrayList<>();

    public List<String> findWinner(List<Car> cars) {
        for (Car car : cars) {
            findWinner(car);
        }
        return this.winners;
    }

    private void findWinner(Car car) {
        if(car.location() == this.maxLocation) {
            this.winners.add(car.name());
        }
        if(car.location() > this.maxLocation) {
            this.maxLocation = car.location();
            this.winners.clear();;
            this.winners.add(car.name());
        }
    }
}

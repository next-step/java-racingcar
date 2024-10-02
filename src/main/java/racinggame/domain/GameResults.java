package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<Integer> positions;

    public GameResults() {
        this.positions = new ArrayList<>();
    }

    public void add(int position) {
        positions.add(position);
    }

    public int carCount() {
        return positions.size();
    }

    public int getCarPosition(int carIndex) {
        return positions.get(carIndex);
    }

    public void save(List<Car> cars) {
        for (Car car : cars) {
            add(car.getPosition());
        }
    }

}

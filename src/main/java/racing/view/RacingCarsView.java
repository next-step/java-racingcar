package racing.view;

import racing.application.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsView {
    private List<Integer> positions = new ArrayList();

    public RacingCarsView(List<Car> cars) {
        cars.stream().forEach(v -> this.positions.add(v.getPosition()));
    }

    public List<Integer> getPositions() {
        return positions;
    }
}



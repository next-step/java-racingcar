package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        this.carList = carList;
    }

    public List<Position> move() {
        List<Position> positions = new ArrayList<>();
        for (Car car : carList) {
            positions.add(car.move(new RandomNumberGenerator()));
        }

        return positions;
    }
}

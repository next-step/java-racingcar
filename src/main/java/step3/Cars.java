package step3;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(List<Integer> integers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(integers.get(i));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}

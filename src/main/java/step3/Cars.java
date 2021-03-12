package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move(Limit limit) {
        cars.forEach(car -> {
            boolean move = car.isMove(RandomUtil.nextInt(RandomUtil.BOUND10), limit.getLimit());
            car.move(move);
        });
    }

    public List<Car> getCars() {
        return this.cars;
    }
}

package new_racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(int playerCount) {
        this.cars = createCar(playerCount);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> createCar(int playerCount) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < playerCount; i++) {
            cars.add(new Car(MoveOneStrategy.INSTANCE));
        }

        return cars;
    }

    public Round run() {
        List<Car> moveCars = cars.stream()
                .map(c -> c.move(RandomUtil.getValue()))
                .collect(Collectors.toList());

        return new Round(new Cars(moveCars));
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }
}

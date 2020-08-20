package carracing.domain.car;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars); // defensive copy : 생성자의 인자로 받은 객체를 복사.

    }

    public List<Car> getCars() {
        return cars;
    }
}

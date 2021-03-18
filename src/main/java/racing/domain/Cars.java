package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.util.RandomUtil;

public class Cars {

    public static final int EMPTY_VALUE = 0;
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for (String carName : carNames) {
            this.cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
  
    public void race() {
        cars.forEach(car -> car.tryMove(RandomUtil.random()));

    }
}

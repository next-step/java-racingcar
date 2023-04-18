package racing.domain;

import racing.service.RandomGameRule;

import java.util.ArrayList;
import java.util.List;

public class Cars { // 일급컬렉션
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car theCar(int index) {
        return this.cars.get(index);
    }

    public int size() {
        return this.cars.size();
    }

    public Cars playOnceTurn() {

        List<Car> movedCars = new ArrayList<>();
        RandomGameRule randomGameRule = new RandomGameRule();

        for (int i = 0; i < this.cars.size(); i++) {
            int randomNumber = randomGameRule.getPossibleInt();
            Car car = this.cars.get(i).move(randomNumber);
            movedCars.add(car);
        }
        return new Cars(movedCars);
    }
}

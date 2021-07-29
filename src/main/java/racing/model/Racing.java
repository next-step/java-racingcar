package racing.model;


import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private Cars cars = new Cars();
    
    public Racing(String[] carNames) {
        this.cars.prepareCars(carNames);
    }

    public Racing(List<Car> cars) {
        this.cars.prepareCars(cars);
    }

    public Cars participants() {
        return this.cars;
    }

    public List<Car> winner() {
        int maxDistance = cars.getMaxDistance();
        List<Car> cars = participants().carList()
                .stream()
                .filter(car -> car.checkDistance(maxDistance))
                .collect(Collectors.toList());
        return cars;
    }
}

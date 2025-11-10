package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.model.Car;
import racingGame.model.Rules;

public class CarFactory {
    
    private final List<Car> cars = new ArrayList<>();
    private Rules rules;
    
    public CarFactory(Rules rules) {
        this.rules = rules;
    }
    
    public List<Car> createCars() {
        while(rules.isLimitCars(this.cars.size())) {
            this.cars.add(new Car());
        }
        return cars;
    }
}

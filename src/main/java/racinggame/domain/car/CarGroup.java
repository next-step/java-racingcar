package racinggame.domain.car;

import racinggame.domain.rule.RacingRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    List<Car> cars;

    public CarGroup(String[] carNames){
        this.cars = Arrays.stream(carNames).map(carName-> new Car(carName, 0)).collect(Collectors.toList());
    }

    public void carMove(RacingRule racingRule){
        cars.stream().forEach(car -> car.move(racingRule));
    }

    public List<Car> getGroupCars(){
        return cars;
    }

}

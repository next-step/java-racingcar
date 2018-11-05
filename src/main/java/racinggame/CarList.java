package racinggame;

import racinggame.rule.RacingRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    List<Car> cars;

    public CarList(String[] carNames) {
        this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void carMove(RacingRule racingRule){
        cars.stream().forEach(car -> car.move(racingRule));
    }

    public int getMaxLocation() {
        return cars.stream().collect(Collectors.summarizingInt(Car::getLocation)).getMax();
    }

    public List<String> getVictorCar(){
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(car -> car.equalsPosition(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars(){
        return cars;
    }

}

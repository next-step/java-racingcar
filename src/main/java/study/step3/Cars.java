package study.step3;

import study.step2.StringValidator;
import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    //불변
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String carNames){
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames.split(StringValidator.CAR_NAME_SPLIT_DELIMITER)){
            Name name = new Name(carName);
            Car car = new Car(name);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public static Cars of(List<Car> cars){
        return new Cars(cars);
    }
    /**
     * 상태와 로직을 한곳에!
     * */
    public void move(MoveStrategy moveStrategy){
        for(Car car : cars){
            car.move(moveStrategy);
        }
    }
    public List<Car> getCars(){
        return cars;
    }

    public List<Car> winners(){
        return maxCars();
    }

    private List<Car> maxCars(){
        Position max = max();
        return cars.stream()
                .filter(x-> x.position().equals(max))
                .collect(Collectors.toList());
    }

    private Position max(){
        Position max = new Position();
        for(Car car : cars){
            Position position = car.position();
            max = position.max(max);
        }
        return max;
    }
}

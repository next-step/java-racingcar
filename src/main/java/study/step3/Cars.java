package study.step3;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    //불변
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
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
    public List<Car> getWinners(){
        return selectMaxCar();
    }
    private List<Car> selectMaxCar(){
        int max = cars.stream()
                .map(Car::getPosition)
                .reduce(0,Math::max);
        return cars.stream().
                filter(x-> x.getPosition() == max)
                .collect(Collectors.toList());
    }
}

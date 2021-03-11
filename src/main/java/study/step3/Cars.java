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
    public void move(){
        for(Car car : cars){
            car.move(new RandomMoveStrategy());
        }
    }
    public List<Car> getCars(){
        return cars;
    }
    public List<Car> getWinners(){
        return selectMaxCar();
    }
    private List<Car> selectMaxCar(){
        Optional<Car> maxCar = cars.stream().max((x,y)->Integer.compare(x.getPosition(),y.getPosition()));
        return cars.stream().filter(x-> x.getPosition() == maxCar.get().getPosition())
                .collect(Collectors.toList());
    }
}

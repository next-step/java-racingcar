package racingcar.model;

import racingcar.util.RandomNumberUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public int getCarsCount(){
        return cars.size();
    }

    public List<Integer> getCarsPositions(){
        return cars.stream().map(car -> car.getPosition()).collect(Collectors.toList());
    }

    public void movable(){
        cars.stream().forEach(car -> car.movable(RandomNumberUtils.executeRandomNumber()));
    }

}

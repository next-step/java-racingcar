package racingcar.model;

import racingcar.utils.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move(){
        for(Car car: cars){
            car.move();
        }
        return cars;
    }

    public void printResult(){
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + StringUtil.repeat("-", car.getPosition()));
        }
    }

}

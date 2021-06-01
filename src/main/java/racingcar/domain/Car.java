package racingcar.domain;

import java.util.List;

public class Car {
    private List<Cars> cars;

    public Car(){
    }

    public List<Cars> add(String carName){
        cars.add(new Cars(carName));
        return this.cars;
    }
}

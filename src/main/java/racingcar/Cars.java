package racingcar;

import java.util.*;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public void createCars(int count){
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }

    public int getSize(){
        return this.cars.size();
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}



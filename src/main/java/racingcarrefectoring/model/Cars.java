package racingcarrefectoring.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carsName){
        for (String carName : Splitter.splitName(carsName)) {
            cars.add(new Car(carName));
        }
    }

    public Car getCar(int index){
        return cars.get(index);
    }

    public int getCount(){
        return cars.size();
    }

}

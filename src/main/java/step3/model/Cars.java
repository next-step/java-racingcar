package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<Car>();

    public Cars(int carCount){
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars(){
        return this.cars;
    }
}

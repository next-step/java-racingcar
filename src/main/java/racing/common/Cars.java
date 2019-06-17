package racing.common;

import racing.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }
    
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

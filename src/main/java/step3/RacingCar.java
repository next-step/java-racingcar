package step3;


import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    List<Car> initCars(int car){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<car; i++){
            cars.add(new Car());
        }
        return cars;
    }
}

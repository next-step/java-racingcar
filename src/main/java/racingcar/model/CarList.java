package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public List<Car> addCar(int carNum){
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carNum; i++){
            Car car = new Car();
            carList.add(car);
        }
        return carList;
    }
}

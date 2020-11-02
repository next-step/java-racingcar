package study1.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();

    CarList(int carCnt){
        this.carList = Collections.nCopies(carCnt, new Car());
    }

    public void race(){
        for(Car car: this.carList){
            car.move();
        }
    }

    public List<Car> getCarList(){
        return carList;
    }
}

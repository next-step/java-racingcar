package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void createCars(){
        for (int i = 0; i < InputView.carCount; i++) {
            carList.add(new Car());
        }
    }

    public int getSize(){
        return carList.size();
    }

    public Car getCarList(int i){
        return carList.get(i);
    };
}
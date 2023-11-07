package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public void addCar(Car car){
        this.carList.add(car);
    }

    public Car getCar(int number){
        return carList.get(number);
    }
    
    public int getSize(){
        return carList.size();
    }
}

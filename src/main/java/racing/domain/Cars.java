package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Car getCar(int number){
        return carList.get(number);
    }
    
    public int getSize(){
        return carList.size();
    }

    public void makeCarList(int carCount) {
        for(int i = 0; i< carCount; i++){
            carList.add(new Car());
        }
    }

}

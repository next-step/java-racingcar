package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public void createCars(int count){
        for (int i = 0; i < count; i++) {
            carList.add(new Car());
        }
    }

    public int getSize(){
        return this.carList.size();
    }
}
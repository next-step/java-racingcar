package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static List<Car> carList = new ArrayList<>();

    public static void createCars(int count){
        for (int i = 0; i < count; i++) {
            carList.add(new Car());
        }
    }

    public int getSize(){
        return this.carList.size();
    }
}
package step4.model;

import java.util.ArrayList;
import java.util.List;

public class MakeCarList {
    public static List<Car> makeList(String... names){
        List<Car> carList = new ArrayList<>();
        for(String name : names){
            carList.add(new Car(name,0));
        }
        return carList;
    }
}

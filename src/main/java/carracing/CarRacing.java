package carracing;

import java.util.ArrayList;

public class CarRacing {
    public static ArrayList<Car> createCars(int totalCars) {
        ArrayList<Car> carList = new ArrayList<>();
        for(int i = 0 ; i < totalCars ; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

package step3;

import java.util.ArrayList;

public class CarStorage {
    private static final int DISTANCE_START = 0;

    public static ArrayList<Car> exit(int carCount) {
        ArrayList<Car> cars = new ArrayList<Car>();

        for(int count = 1; count <= carCount; count++){
            cars.add(new Car(DISTANCE_START));
        }

        return cars;
    }


}

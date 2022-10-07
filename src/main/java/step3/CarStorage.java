package step3;

import java.util.ArrayList;

public class CarStorage {
    private static final int START_POINT = 0;

    public static ArrayList<Car> exit(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();

        for(int count = 0; count < carNames.length; count++){
            String name = carNames[count];
            cars.add(new Car(START_POINT,name));
        }

        return cars;
    }


}

package RacingCar.Model;

import java.util.ArrayList;

public class RegisteredCar {
    ArrayList<Car> cars = new ArrayList<Car>();

    public ArrayList<Car> getRegisteredCar() {
        return cars;
    }

    public void makeCar(String[] carName) {
        for (int i = 0; i < carName.length; i++)
            cars.add(new Car(0, carName[i]));
    }
}

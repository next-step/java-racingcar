package racing.factory;

import racing.domain.Car;

public class CarFactory {

    public Car[] manufactureCars(String text) {
        String[] names = text.split(",");
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

}

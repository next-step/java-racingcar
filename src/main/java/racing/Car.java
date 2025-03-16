package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int START_POSITION = 1;
    private int position;
    private final String name;

    public Car(String name) {
        this.position = START_POSITION;
        this.name = name;
    }

    public int move(boolean canProgress) {
        if (canProgress) {
            this.position++;
        }
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public static List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String s : names) {
            cars.add(new Car(s));
        }
        return cars;
    }

}

package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int START_POSITION = 1;
    public static final int MIN_PROGRESS_NUMBER = 4;
    private int position;
    private final CarName name;

    private Car(CarName name) {
        this.position = START_POSITION;
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(new CarName(name));
    }

    public int move(int number) {
        if (canProgress(number)) {
            this.position++;
        }
        return this.position;
    }


    public boolean canProgress(int number) {
        return number >= MIN_PROGRESS_NUMBER;
    }

    public boolean isPosition(int position){
        return this.position == position;
    }

    public String getName(){
        return this.name.getName();
    }

    public static List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String s : names) {
            cars.add(Car.of(s));
        }
        return cars;
    }

}

package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int START_POSITION = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private int position;
    private final String name;

    private Car(String name) {
        this.position = START_POSITION;
        this.name = name;
    }

    public static Car of(String name) {
        if (checkNameLengthExceed(name)){
            return new Car(name);
        }
        throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다. input: " + name);
    }

    private static boolean checkNameLengthExceed(String name) {
        return name.length() <= MAX_NAME_LENGTH;
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
            cars.add(Car.of(s));
        }
        return cars;
    }

}

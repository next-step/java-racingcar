package racecar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static List<Car> carList;
    private String name;
    private int position;

    public Car() {
        this.position = 1;
    }

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public static void ready(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++)
            carList.add(new Car());
    }

    public static List<Car> ready(String[] carName) {
        carList = new ArrayList<>();
        for (int i = 0, carSize = carName.length; i < carSize; i++)
            carList.add(new Car(carName[i]));
        return carList;
    }


    public static List<Car> getCarList() {
        return carList;
    }

    public int move(Random random) {
        if (random.nextInt(Rules.BOUND) >= Rules.WIN_CONDITION)
            this.position += 1;
        return this.position;
    }

    public String makePositionStatus() {
        String result = "-".repeat(position);
        return result;
    }

}

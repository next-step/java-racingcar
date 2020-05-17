package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static List<Car> carList;
    private final int WIN_CONDITION = 4;
    private int position;

    public Car() {
        position = 1;
    }

    public static void generate(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++)
            carList.add(new Car());
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public int move(int fuel) {
        if (checkPass(fuel))
            this.position = this.position + 1;
        return this.position;
    }

    public int getPosition() {
        return position;
    }

    boolean checkPass(int number) {
        return number >= WIN_CONDITION;
    }

}

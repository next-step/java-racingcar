package racecar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static List<Car> carList;

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
        if (RacingGame.checkPass(fuel))
            this.position = this.position + 1;
        return this.position;
    }

    public String makePositionStatus() {
        String result = "-".repeat(position);
        return result;
    }

}

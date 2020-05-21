package racecar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Car {
    private static List<Car> carList;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public static List<Car> ready(String[] carName) {
        carList = new ArrayList<>();
        for (int i = 0, carSize = carName.length; i < carSize; i++)
            carList.add(new Car(carName[i].trim()));
        return carList;
    }

    public static int getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : carList)
            positions.add(car.position);
        int max = Collections.max(positions);
        return max;
    }

    public static List<String> selectWinner(int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.position == max)
                winners.add(car.name);
        }
        return winners;
    }

    public int move(Random random) {
        int number = random.nextInt(Rules.BOUND);
        if (number >= Rules.WIN_CONDITION)
            this.position += 1;
        return this.position;
    }

    public String printStatus() {
        String status = "-".repeat(position);
        String result = name + " : " + status;
        return result;
    }
}

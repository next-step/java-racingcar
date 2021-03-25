package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    final static int CAN_GO = 4;

    public Racing(int carCount, int lapCount) {
        List<Car> cars = getCarReady(carCount);
        onRacing(cars, lapCount);
    }

    private List<Car> getCarReady(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void onRacing(List<Car> cars, int lapCount) {
        System.out.println("\n ======== LAP : " + lapCount + "th to last ========");
        for (int i = 0; i < cars.size(); i++) {
            lap(cars.get(i));
        }
        printRacing(cars);
        lapCount--;

        if (lapCount > 0) {
            onRacing(cars, lapCount);
        }
    }

    private void lap(Car car) {
        if (castDice() >= CAN_GO) {
            car.position++;
        }
    }

    private int castDice() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private void printRacing(List<Car> cars) {
        System.out.println();
        for (Car c : cars) {
            printCarPosition(c);
            System.out.print("🚘\n");
        }
    }

    private void printCarPosition(Car c) {
        int position = c.getPosition();
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}

package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    public CarRacing(int carCount, int tryCount) {
        List<Car> cars = getCarReady(carCount);
        onRacing(cars, tryCount);
    }

    private List<Car> getCarReady(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void onRacing(List<Car> cars, int tryCount) {
        System.out.println("\n ++++++++ LAP : " + tryCount + "th to last +++++++++ ");
        for (int i = 0; i < cars.size(); i++) {
            lap(cars.get(i));
        }
        printRacing(cars);
        tryCount--;

        if (tryCount > 0) {
            onRacing(cars, tryCount);
        }
    }

    private void lap(Car car) {
        System.out.print("befor : " + car.getPosition());
        car.position = car.getPosition() + getMove();
        System.out.println("   ->   after : " + car.getPosition());
    }

    private int getMove() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private void printRacing(List<Car> cars) {
        System.out.println();
        for (Car c : cars) {
            int position = c.getPosition();
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}

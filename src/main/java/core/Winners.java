package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners decideWinners(Cars cars) {
        List<Car> result = new ArrayList<>();
        int currentMaxPosition = 0;
        for (Car car : cars.getCars()) {
            currentMaxPosition = comparePosition(result, currentMaxPosition, car);
        }
        return new Winners(result);
    }

    private static int comparePosition(List<Car> result, int currentMaxPosition, Car car) {
        if (car.getPosition() > currentMaxPosition) {
            currentMaxPosition = car.getPosition();
            result.clear();
            result.add(car);
        } else if (car.getPosition() == currentMaxPosition) {
            result.add(car);
        }
        return currentMaxPosition;
    }

    public void printWinners() {
        Iterator<Car> iterator = cars.iterator();
        if (iterator.hasNext()) {
            System.out.print(iterator.next().getCarName());
        }
        while (iterator.hasNext()) {
            System.out.println(", " + iterator.next().getCarName());
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public List<Car> getCars() {
        return cars;
    }
}

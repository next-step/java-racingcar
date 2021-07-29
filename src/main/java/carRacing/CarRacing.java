package carRacing;


import java.util.ArrayList;
import java.util.Random;

public class CarRacing {

    private ArrayList<Car> prepareCars(int numberOfCars) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i<numberOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    void start(int numberOfCars, int numberOfRacing) {
        Random random = new Random();
        ArrayList<Car> cars = prepareCars(numberOfCars);

        for (int round = 1; round <= numberOfRacing; round++) {
            ResultView.divideRound(round);

            for (Car car : cars) {
                if (car == null) {
                    throw new NullPointerException("유효하지 않은 car 객체입니다.");
                }
                int position = car.go(random);
                ResultView.printPosition(position);
            }
        }
    }
}

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
            System.out.println();
            if (round == 1) {
                System.out.println("실행결과");
            }
            for (Car car : cars) {
                int position = car.go(random);
                StringBuilder state = new StringBuilder();
                for (int i = 0; i < position; i++) {
                    state.append("-");
                }
                System.out.println(state);
            }
        }
    }
}

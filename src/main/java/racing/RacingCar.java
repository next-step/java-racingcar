package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return cars;
    }


    public void activeTurns(int turn) {
        for (int i = 0; i < turn; i++) {
            this.activeCar();
        }
    }

    protected void activeCar() {
        System.out.println("todo");
    }

    public static boolean canProgress(int randomNumber) {
        return randomNumber >= 4;
    }
}

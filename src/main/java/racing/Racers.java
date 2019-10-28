package racing;

import java.util.ArrayList;
import java.util.List;

public class Racers {
    private static final String POSITION_SIGNATURES = "-";

    private List<Car> cars = new ArrayList<>();

    public Racers(int size) {
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(CountGenerator.getRandomInt());
        }
        result();
    }

    private void result() {
        for (Car car : cars) {
            printPosition(car.position());
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_SIGNATURES);
        }
        System.out.println();
    }
}

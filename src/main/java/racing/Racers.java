package racing;

import java.util.ArrayList;
import java.util.List;

public class Racers {
    private static final String RACER_NAME_SEPARATOR = ",";
    private List<Car> cars = new ArrayList<>();

    public Racers(String racerNames) {
        String[] racers = racerNames.split(RACER_NAME_SEPARATOR);
        for (String racer : racers) {
            cars.add(new Car(racer));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(CountGenerator.getRandomInt());
        }
    }

    public int size() {
        return cars.size();
    }

    public String getRacerName(int index) {
        return cars.get(index).getName();
    }

    public int getPosition(int index) {
        return cars.get(index).position();
    }
}

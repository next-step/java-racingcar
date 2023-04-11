package study.step3;


import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Car> cars = new ArrayList<>();

    Track(int carCount, int finish) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(finish));
        }
    }

    public void startRacing() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Boolean isRaceEnd() {
        int lastCarNumber = cars.size() - 1;
        return cars.get(lastCarNumber).isFinish();
    }

    public List<Car> getCars() {
        return cars;
    }

}

package step4.domain;

import step4.service.RacingCarService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final List<Car> carList = new ArrayList<>();

    public Cars(String[] nameArr) {
        for (String name : nameArr) {
            add(new Car(name, RacingCarService.movingStrategy));
        }
    }

    public int carCount() {
        return carList.size();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public List<Integer> race() {
        List<Integer> resultPerRound = new ArrayList<>();
        for (Car car : carList) {
            car.move();
            resultPerRound.add(car.distance());
        }

        return Collections.unmodifiableList(resultPerRound);
    }
}

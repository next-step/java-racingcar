package carRacing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RacingProcess {

    private final int carCount;
    private final Cars cars;

    public RacingProcess(int carCount) {

        this.carCount = carCount;
        this.cars = new Cars(generateCarList());
    }


    private List<Car> generateCarList() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void roundPlay(NumberGenerator numberGenerator) {
        cars.move(numberGenerator);
    }

    public List<Integer> getCarsDistance() {
        return cars.getDistances();
    }
}

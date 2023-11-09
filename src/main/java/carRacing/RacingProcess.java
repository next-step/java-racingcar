package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingProcess {
    private final Cars cars;

    public RacingProcess(String[] nameArray, MovingStrategy movingStrategy) {

        this.cars = new Cars(generateCarList(nameArray, movingStrategy));
    }

    private List<Car> generateCarList(String[] nameArray, MovingStrategy movingStrategy) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameArray) {
            carList.add(new Car(name, movingStrategy));
        }
        return carList;
    }

    public void roundPlay(NumberGenerator numberGenerator) {
        cars.operate(numberGenerator);
    }

    public List<Car> getCarsStatus() {
        return cars.getCarListForPrint();
    }

    public List<String> callCarRacingWinners() {
        return cars.callWinners();
    }
}

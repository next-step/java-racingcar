package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        cars.move(numberGenerator);
    }

    public Map<String, Integer> getCarsStatus() {
        return cars.getState();
    }

    public List<String> callCarRacingWinners() {
        return cars.callWinners();
    }

    ;
}

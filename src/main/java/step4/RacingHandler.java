package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingHandler {
    private final Cars cars;
    private final RandomNumber randomNumber;

    public RacingHandler(String[] carNames) {
        this.cars = new Cars(addToList(carNames));
        this.randomNumber = new RandomNumber();
    }

    public Map<String, Integer> getCarNameAndLocation() {
        return cars.storeCarNameAndLocation();
    }

    public void moveCar() {
        cars.moveCar(randomNumber);
    }

    public List<String> getWinnerName() {
        return cars.findWinner();
    }

    private List<Car> addToList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

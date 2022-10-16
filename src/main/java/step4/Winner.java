package step4;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> carList = new ArrayList<>();
    private final Cars cars;
    private final MaxLocation maxLocation = new MaxLocation();

    public Winner(String[] carNames) {
        addToList(carNames);
        this.cars = new Cars(carList);
    }

    public List<String> findLocationAndWinnerName() {
        printResult();
        return getWinnerName();
    }

    private List<String> getWinnerName() {
        return cars.findWinnerName(maxLocation);
    }

    private void printResult() {
        cars.printLocations(maxLocation);
    }

    private void addToList(String[] carNames) {
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }
}

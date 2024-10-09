package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final static String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();


    public Cars(final String userInput) {
        String[] carNames = userInput.split(DELIMITER);
        this.create(carNames);
    }

    private void create(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i].trim()));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
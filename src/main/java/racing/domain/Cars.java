package racing.domain;

import java.util.ArrayList;
import java.util.List;


public class Cars extends ArrayList<Car> {
    private List<Car> cars;


    static final int NAME_LENGTH = 5;
    static final String CAR_NAME_SPLIT = ",";

    public Cars initCars(String carNamesStr) {
        String[] carNames = initCarName(carNamesStr);
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public String[] initCarName(String carNamesStr) {
        String[] carNames = carNamesStr.split(CAR_NAME_SPLIT);
        for (String carName : carNames) {
            if (carName.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이내로 .");
            }
        }
        return carNames;
    }
}

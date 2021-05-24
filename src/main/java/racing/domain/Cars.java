package racing.domain;

import java.util.ArrayList;
import java.util.List;


public class Cars{
    private List<Car> cars;


    static final int NAME_LENGTH = 5;
    static final String CAR_NAME_SPLIT = ",";

    public Cars() {
        this.cars = new ArrayList<>();
    }
    public Cars(String carNamesStr) {
        this.cars = initCars(carNamesStr);
    }
    private List<Car> initCars(String carNamesStr) {
        this.cars = new ArrayList<>();
        String[] carNames = initCarName(carNamesStr);
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

    public List<Car> getCars() {
        return cars;
    }

    public void add(Car car){
        this.cars.add(car);
    }
}

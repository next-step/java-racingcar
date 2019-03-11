package racingcar.racingcar_refactoring_version2;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    private RaceRuleManager ruleManager;


    public List<Car> getCars() {
        return cars;
    }

    public Race(String carNames) {
        this.cars = setupCar(carNames);
        this.ruleManager = new RaceRuleManager();
    }

    private List<Car> setupCar(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void run() {
        for (Car car : cars) {
            if (ruleManager.canMove()) {
                car.moveCar();
            }
        }
    }


}

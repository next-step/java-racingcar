package carRacing;

import carRacing.model.Car;
import carRacing.util.RandomIntUtil;
import carRacing.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {
    final static String DELIMITER = ",";
    private List<Car> cars;
    private OutputView outputView;

    public CarRacing(String carNames) {
        this.cars = new ArrayList<>();
        outputView = new OutputView();
        enrollCars(carNames);
    }


    public void startRacing(int racingCount) {
        outputView.printRacingResultTitle();
        for (int cycle = 0; cycle < racingCount; cycle++) {
            excuteCycle();
            outputView.printRacingResultExcutedCycle(cars, cycle);
        }
    }

    private void excuteCycle() {
        for (Car car : cars) {
            car.moveByRandomInt(RandomIntUtil.getRandomInt());
        }
    }

    private void enrollCars(String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        Arrays.stream(carNameList).forEach(carName -> this.cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void racingWinner() {
//        List<String> winnerCars = cars.stream().toArray();
//
//        outputView.printRacingWinner(String.join(DELIMITER, winnerCars));
    }
}

package racing.domain;

import racing.utils.RandomUtils;
import racing.views.ResultView;

public class RacingGame {

    private final Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public RacingGame(int carCounts) {
        this.cars = generateCars(carCounts);
    }

    public RacingGame(String[] carNames) {
        this.cars = generateCarsWithName(carNames);
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            car.move(RandomUtils.generateRandomNumber(10));
            ResultView.printResultWithName(car);
        }
        ResultView.println("");
    }

    private Cars generateCars(int carCount) {
        Cars cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }
        return cars;
    }

    private Cars generateCarsWithName(String[] carNames) {
        Cars cars = new Cars();
        for(String carName : carNames){
            cars.addCar(new Car(carName));
        }
        return cars;
    }
}
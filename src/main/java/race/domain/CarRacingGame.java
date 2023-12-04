package race.domain;

import race.util.RandomNumberUtil;
import race.view.ResultView;

public class CarRacingGame {
    private final Cars cars;

    public CarRacingGame(Cars cars) {
        this.cars = cars;
    }

    public void play(){
        for (Car car : cars.getCars()) {
            car.move(RandomNumberUtil.getRandomNumber());
            ResultView.printCarPosition(car);
        }
        System.out.println();
    }
}

package study.step5;

import java.util.List;

import study.step5.domain.Car;
import study.step5.domain.Cars;
import study.step5.domain.RandomMovingStrategy;

/**
 * Racing Game Class
 *
 * 자동차 경주 클래스
 *
 */
public class Racing {
    private Cars cars;
    private RacingWinner racingWinner;

    public Racing() {
        cars = new Cars();
        racingWinner = new RacingWinner();
    }

    public void setUp(String[] names) {
        for(int i=0; i<names.length; i++) {
            cars.addCars(new Car(names[i]));
        }
    }

    public List<Car> getCarList() {
        //return this.cars.toString();
        return null;
    }

    public void run() {
        cars.run(new RandomMovingStrategy());
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}

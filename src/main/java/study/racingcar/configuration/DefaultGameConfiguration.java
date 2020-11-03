package study.racingcar.configuration;

import study.racingcar.car.Car;
import study.racingcar.car.moving.CarMovingStrategy;
import study.racingcar.view.InputView;

import java.util.List;

public class DefaultGameConfiguration extends AbstractGameConfiguration{

    public DefaultGameConfiguration(InputView inputView, int numberOfCars, int numberOfTries, CarMovingStrategy strategy) {

        inputView.numberOfCarsMessage();
        this.numberOfCars = numberOfCars;

        inputView.numberOfTriesMessage();
        this.numberOfTries = numberOfTries;

        this.strategy = strategy;

        validate();
    }

    @Override
    public boolean doMoreTry(int count) {
        return this.numberOfTries > count;
    }
}

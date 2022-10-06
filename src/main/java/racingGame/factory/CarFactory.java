package racingGame.factory;

import racingGame.domain.Car;

public abstract class CarFactory {
    public abstract Car createCar(String CarName);
}

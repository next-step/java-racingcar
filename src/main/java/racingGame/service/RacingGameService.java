package racingGame.service;

import racingGame.model.car.Cars;
import racingGame.model.car.CarMovement;
import racingGame.model.car.Car;
import racingGame.model.car.TryNo;
import racingGame.model.numbergenerator.NumberGenerator;
import racingGame.model.numbergenerator.RandomNumberGenerator;

public class RacingGameService {

    private static final int MINIMUM_MOVEMENT_VALUE = 4;

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RacingGameService() {}

    public CarMovement moveCarsForAllRounds(int carCount, TryNo tryNo) {
        Cars cars = new Cars(carCount);
        CarMovement ret = new CarMovement();

        for (int i = 0; i < tryNo.getTryNo(); i++) {
            Cars car = moveCarsByOneStep(cars);
            ret.addOneStepProgress(car);
        }

        return ret;
    }

    private Cars moveCarsByOneStep(Cars cars) {
        for (Car car : cars.getCarGroup()) {
            car.move(() ->
                numberGenerator.generateNumber() >= MINIMUM_MOVEMENT_VALUE
            );
        }
        return cars;
    }

}

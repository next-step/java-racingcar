package racingGame;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGameV1 {
    private InputParameters inputParameters;

    public RacingGameV1(InputParameters inputParameters) {
        this.inputParameters = inputParameters;
    }

    public List<Car> play(RacingRule racingRule) {
        //start 메서드에서 car리스트 생성, car 생성, car움직임 까지 함 너무 많음
        List<Car> cars = new ArrayList<>();
        startRacing(racingRule, cars);
        return cars;
    }

    private void startRacing(RacingRule racingRule, List<Car> cars) {
        for (int k = 0; k < inputParameters.getCarNum(); k++) {
            Car car = new Car();
            tryMove(racingRule, car);
            cars.add(car);
        }
    }

    private void tryMove(RacingRule racingRule, Car car) {
        for (int i = 0; i < inputParameters.getTryNum(); i++) {
            moveOrNot(racingRule, car);
        }
    }

    private void moveOrNot(RacingRule racingRule, Car car) {
        if (checkCanMove(racingRule)){
            car.move();
            return;
        }
        car.notMove();
    }

    private boolean checkCanMove(RacingRule racingRule) {
        return racingRule.createRandomResult();
    }
}

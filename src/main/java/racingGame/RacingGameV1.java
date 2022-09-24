package racingGame;

import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGameV1 {
    private GameInput gameInput;

    public RacingGameV1(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    public List<Car> start(RacingRule racingRule) {
        //랜덤 값이 4이상 인걸 알아야한다.
        // 그 후 움직인다.
        //움직이는 건 RGV1의 할일일까?
        List<Car> cars = new ArrayList<>();
        for (int k = 0; k < gameInput.getCarNum(); k++) {
            Car car = new Car();
            for (int i = 0; i < gameInput.getTryNum(); i++) {
                if (racingRule.createRandomResult() > 4) {
                    car.move();
                }
            }
            cars.add(car);
        }
        return cars;
    }
}

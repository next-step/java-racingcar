package racingcar.step3;

import java.util.List;

public class Race {

    public void startRacingGame(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move();
        }
    }

}

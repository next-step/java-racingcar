package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingService {
    public ArrayList<Car> getCarInfos(Racing racing) {
        return racing.getCars();
    }

    public void moveByNumOfTriesAndShowResult(Racing racing) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < racing.getNumOfTries(); i++) {
            move(racing);
            resultView.showCurrentState(getCarInfos(racing));
        }
    }

    public void move(Racing racing) {
        racing.getCars().stream()
                .map(car -> {
                    car.setResultOfRand(getRand(10));
                    return car;
                })
                .filter(car -> car.getResultOfRand() > 4)
                .forEach(Car::moveFoward);
    }

    private int getRand(int bound) {
        int rand = new Random().nextInt(bound);
        return rand;
    }
}

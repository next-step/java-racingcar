package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingService {

    public void moveByNumOfTriesAndShowResult(Racing racing) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < racing.getNumOfTries(); i++) {
            move(racing);
            resultView.showCurrentState(racing.getCars());
        }
    }

    public void move(Racing racing) {
        ArrayList<Car> newCars = (ArrayList<Car>) racing.getCars().stream()
                .map(car -> {
                    int rand = generateRand();
                    return rand > racing.getThreshold() ? car.moveFoward(rand) : car;
                }).collect(Collectors.toList());
        racing.setCars(newCars);
    }

    private int generateRand() {
        return new Random().nextInt(10);
    }
}

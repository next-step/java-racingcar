package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final int numOfCar;
    private final int numOfTries;

    public Racing(int numOfCar, int numOfTries) {
        this.numOfCar = numOfCar;
        this.numOfTries = numOfTries;
    }

    public List<MidScore> startAndGetScoreList() {

        List<MidScore> midScoreList = new ArrayList<>();
        List<Car> racingCars = new ArrayList<>(Collections.nCopies(numOfCar, new Car(0)));

        for (int value = 1; value <= numOfTries; value++) {
            racingCars = doRacingOnce(racingCars);
            midScoreList.add(new MidScore(racingCars));
        }

        return midScoreList;
    }

    private List<Car> doRacingOnce(List<Car> cars) {

        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

    }


}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameDecision {
    private List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> Decision(String[] carNames){
        for (int i = 0; i < carNames.length; i++) {
            RacingCar racingCar = new RacingCar(carNames[i]);
            racingCars.add(racingCar);
        }
    return racingCars;
    }

}

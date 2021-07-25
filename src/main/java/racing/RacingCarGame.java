package racing;

import racing.model.NumberGenerator;
import racing.model.RacingCars;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarGame {
    public static void main(String[] args) {
        int racingCarCount = 3;

        RacingCars racingCars = new RacingCars(racingCarCount);
        NumberGenerator numberGenerator = new NumberGenerator();
        Map<Integer, Integer> racingCarIndexAndNumber = new LinkedHashMap<>();

        for (int index = 0; index < racingCarCount; index++) {
            numberGenerator.generateRandomNumber();
            racingCarIndexAndNumber.put(index, numberGenerator.getNumber());
        }

        racingCars.moveOrStop(Collections.unmodifiableMap(racingCarIndexAndNumber));
    }
}

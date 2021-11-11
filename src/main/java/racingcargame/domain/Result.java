package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<String> currentStates = new ArrayList<>();

    public static Result of(List<RacingCar> racingCars) {
        Result result = new Result();
        racingCars.forEach(racingCar -> {
            result.currentStates.add(racingCar.getCurrentState());
        });
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        currentStates.forEach(currentStates -> {
            sb.append(currentStates).append('\n');
        });
        return sb.toString();
    }

}

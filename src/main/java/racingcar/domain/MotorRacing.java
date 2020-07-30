package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MotorRacing {
    private final List<RacingCar> racingCars;

    public MotorRacing(int carCount) {
        this.racingCars = new ArrayList(carCount);
        for(int i = 0; carCount > i; ++i) {
            racingCars.add(new RacingCar());
        }
    }

    public int participationCount(){
        return racingCars.size();
    }

    public void racing(int tryCount){
        racingCars.forEach((c)->c.race(tryCount));
    }

    @Override
    public String toString() {
        return racingCars.stream()
                  .map(RacingCar::toDisplay)
                  .collect(joining("\n"));
    }
}

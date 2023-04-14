package race.view;

import race.domain.RacingCars;

public class TraceView {

    public void printMoveResult(RacingCars racingCars) {
        racingCars.getList().forEach(car -> System.out.println(car.getTracing()));
    }
}

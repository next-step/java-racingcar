package step3_racing_car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(int participantCarCount) {

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < participantCarCount; i++) {
            racingCars.add(new RacingCar());
        }

        this.racingCars = racingCars;
    }

    public void movePosition(int distance) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).movePositions(distance);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

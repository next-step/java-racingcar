package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public static RacingCars create(int cars) {
        return new RacingCars(cars);
    }

    private RacingCars(int cars) {
        setRacingCars(cars);
    }

    private void setRacingCars(int cars) {
        for (int i = 0; i < cars; i++) {
            this.racingCars.add(RacingCar.create());
        }
    }

    public int size() {
        return this.racingCars.size();
    }

    public void run() {
        racingCars.forEach(RacingCar::move);
    }

    public List<RacingCar> getAll(){
        return racingCars;
    }
}

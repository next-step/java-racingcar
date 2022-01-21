package racinggame.domain;

import java.util.List;

public class View {
    private List<RacingCar> racingCars;

    private View() {}

    public View(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

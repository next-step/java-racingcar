package newcarracing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGameResult(List<RacingCar> racingCars) throws CloneNotSupportedException {
        for (RacingCar car : racingCars) {
            this.racingCars.add((RacingCar) car.clone());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getWinners() {
        int maxPosition = findMaxPosition();
        return this.racingCars.stream().filter(car -> car.isMaxPosition(maxPosition)).collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return this.racingCars.stream().max(RacingCar::compareTo).get().getPosition();
    }


}

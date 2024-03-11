package step3_racing_car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<String> participantCarNames) {

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < participantCarNames.size(); i++) {
            racingCars.add(new RacingCar(participantCarNames.get(i)));
        }

        this.racingCars = racingCars;
    }

    public void movePosition(MovingStrategy movingStrategy) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).movePositions(movingStrategy.move());
        }
    }

    public RacingCars getWinners() {
        int maxDistance = this.racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return (RacingCars) this.racingCars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

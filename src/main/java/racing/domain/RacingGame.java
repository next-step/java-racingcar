package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> gameCars;

    public RacingGame(List<RacingCar> gameCars) {
        this.gameCars = gameCars;
    }

    public List<RacingCar> getGameCars() {
        return Collections.unmodifiableList(gameCars);
    }


    public void progressCycle() {
        for (RacingCar gameCar : gameCars) {
            gameCar.move();
        }
    }

    public List<RacingCar> findWinner() {
        int maxPosition = Collections.max(gameCars).getPosition();
        return gameCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;

import static view.ResultView.displayRacingCarGroup;

public class RacingCarGame {
    private final RacingCarGroups racingCarGroups;
    private final int rounds;

    public RacingCarGame(String carNames, int rounds) {
        this.racingCarGroups = createRacingCars(carNames);
        this.rounds = rounds;
    }

    public RacingCarGroups getRacingCarGroups() {
        return racingCarGroups;
    }

    public int getRounds() {
        return rounds;
    }

    public void runGame() {
        for (int i = 0; i < rounds; i++) {
            racingCarGroups.move();
            displayRacingCarGroup(racingCarGroups);
        }
    }

    public static RacingCarGroups createRacingCars(String carNames) {
        String[] names = carNames.split(",");

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            RacingCar racingCar = new RacingCar(names[i].trim());
            racingCars.add(racingCar);
        }
        return new RacingCarGroups(racingCars);
    }

    public List<CarName> getWinners() {
        return racingCarGroups.findWinners();
    }
}

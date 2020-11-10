package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.ResultView.displayRacingCarGroup;

public class RacingCarGame {
    private final RacingCarGroups racingCarGroups;
    private final int rounds;

    public RacingCarGame(RacingCarGroups racingCarGroups, int rounds) {
        this.racingCarGroups = racingCarGroups;
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

    public static List<RacingCar> createRacingCars(String carNames) {
        String[] names = carNames.split(",");

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            RacingCar racingCar = new RacingCar(names[i].trim());
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    public List<String> getWinners() {
        int max = racingCarGroups.getMaxDistance();
        return racingCarGroups.findWinners(max);
    }
}

package racingcar;

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
            racingCarGroups.display();
        }
    }
}

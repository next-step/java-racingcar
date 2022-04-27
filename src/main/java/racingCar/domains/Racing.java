package racingCar.domains;

public class Racing {
    private PositiveNumber numberOfCars;
    private PositiveNumber rounds;
    private PositiveNumber playedRound;

    public Racing(int cars, int rounds) {
        this(cars, rounds, 0);
    }

    public Racing(int cars, int rounds, int played) {
        this.numberOfCars = new PositiveNumber(cars);
        this.rounds = new PositiveNumber(rounds);
        this.playedRound = new PositiveNumber(played);
    }

    public boolean isPlaying() {
        return playedRound.getNumber() < rounds.getNumber();
    }
}

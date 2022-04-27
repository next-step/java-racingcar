package racingCar.domains;

import java.util.List;

public class Racing {
    private PositiveNumber rounds;
    private PositiveNumber playedRound;
    private Cars cars;

    public Racing(int cars, int rounds) {
        this(cars, rounds, 0);
    }

    public Racing(String cars, String rounds) {
        this(Integer.parseInt(cars), Integer.parseInt(rounds), 0);
    }

    public Racing(int cars, int rounds, int played) {
        this.rounds = new PositiveNumber(rounds);
        this.playedRound = new PositiveNumber(played);
        this.cars = new Cars(new PositiveNumber(cars));
    }

    public boolean isPlaying() {
        return playedRound.getNumber() < rounds.getNumber();
    }

    public void playRound() {
        this.cars.move();
        playedRound.increase();
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }
}

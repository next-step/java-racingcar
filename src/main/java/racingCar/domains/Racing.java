package racingCar.domains;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private PositiveNumber numberOfCars;
    private PositiveNumber rounds;
    private PositiveNumber playedRound;
    List<Car> cars;

    public Racing(int cars, int rounds) {
        this(cars, rounds, 0);
    }

    public Racing(String cars, String rounds) {
        this(Integer.parseInt(cars), Integer.parseInt(rounds), 0);
    }

    public Racing(int cars, int rounds, int played) {
        this.numberOfCars = new PositiveNumber(cars);
        this.rounds = new PositiveNumber(rounds);
        this.playedRound = new PositiveNumber(played);
        this.cars = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car());
        }
    }

    public boolean isPlaying() {
        return playedRound.getNumber() < rounds.getNumber();
    }

    public void playRound() {
        for (Car car : this.cars) {
            car.move();
        }
        playedRound.increase();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}

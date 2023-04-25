package racing.race;

import racing.vehicle.Car;
import racing.vehicle.factory.CarFactory;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Game {
    private Collection<Car> participants;
    private int laps;

    public Game(int participantsCount, int laps) {
        if (participantsCount <= 0) {
            throw new IllegalArgumentException();
        }
        if (laps <= 0) {
            throw new IllegalArgumentException();
        }

        this.participants = CarFactory.createRandomCars(participantsCount);
        this.laps = laps;
    }

    public Stream<Car> participantsStream() {
        return participants.stream();
    }

    public IntStream lapsStream() {
        return IntStream.range(0, laps);
    }

    public void runLap() {
        participants.forEach(Car::move);
    }
}

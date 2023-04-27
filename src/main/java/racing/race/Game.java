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
            throw new IllegalArgumentException("The number of participants must be positive.");
        }
        if (laps <= 0) {
            throw new IllegalArgumentException("The number of laps must be positive.");
        }

        this.participants = CarFactory.createRandomCars(participantsCount);
        this.laps = laps;
    }

    public Collection<Car> getParticipants() {
        return participants;
    }

    public int getLaps() {
        return laps;
    }

    public void runLap() {
        participants.forEach(Car::move);
    }
}

package racing.race;

import racing.vehicle.Car;
import racing.vehicle.CarNames;
import racing.vehicle.Cars;

import java.util.List;

public class Game {
    private final Cars participants;
    private final int laps;

    public Game(String names, int laps) {
        CarNames carNames = new CarNames(names);
        validateLaps(laps);
        this.participants = new Cars(carNames);
        this.laps = laps;
    }

    private void validateLaps(int laps) {
        if (laps <= 0) {
            throw new IllegalArgumentException("The number of laps must be positive.");
        }
    }

    public Cars getParticipants() {
        return participants;
    }

    public List<Car> getWinners() {
        return participants.getWinners();
    }

    public int getLaps() {
        return laps;
    }

    public void runLap() {
        participants.move();
    }
}

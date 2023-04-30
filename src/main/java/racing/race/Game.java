package racing.race;

import racing.vehicle.CarNames;
import racing.vehicle.Cars;

public class Game {
    private Cars participants;
    private int laps;

    public Game(String names, int laps) {
        setParticipants(names);
        setLaps(laps);
    }

    private void setParticipants(String names) {
        CarNames carNames = new CarNames(names);
        this.participants = new Cars(carNames);
    }

    private void setLaps(int laps) {
        validateLaps(laps);
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

    public Cars getWinners() {
        return participants.getWinners();
    }

    public int getLaps() {
        return laps;
    }

    public void runLap() {
        participants.move();
    }
}

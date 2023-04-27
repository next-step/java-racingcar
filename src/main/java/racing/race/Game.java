package racing.race;

import racing.vehicle.Cars;

public class Game {
    private Cars participants;
    private int laps;

    public Game(int participantsCount, int laps) {
        validateLaps(laps);

        this.participants = new Cars(participantsCount);
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

    public int getLaps() {
        return laps;
    }

    public void runLap() {
        participants.move();
    }
}

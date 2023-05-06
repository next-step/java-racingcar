package racing.race;

import racing.vehicle.CarNames;
import racing.vehicle.Cars;

public class Game {
    private final Cars participants;
    private final int laps;

    private Game(Cars participants, int laps) {
        this.participants = participants;
        this.laps = laps;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String carNames;
        private int laps;

        public Builder setCarNames(String carNames) {
            this.carNames = carNames;
            return this;
        }

        public Builder setLaps(int laps) {
            this.laps = laps;
            return this;
        }

        public Game build() {
            CarNames carNames = new CarNames(this.carNames);
            Cars participants = new Cars(carNames);

            validateLaps(this.laps);

            return new Game(participants, this.laps);
        }

        private void validateLaps(int laps) {
            if (laps <= 0) {
                throw new IllegalArgumentException("The number of laps must be positive.");
            }
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

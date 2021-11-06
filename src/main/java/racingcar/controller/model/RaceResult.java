package racingcar.controller.model;

import racingcar.service.value.Position;
import racingcar.service.value.Round;
import racingcar.utils.Preconditions;

import java.util.List;

public class RaceResult {
    private final Round round;
    private final List<Race> races;

    public RaceResult(Round round, List<Race> races) {
        Preconditions.checkNotNull(round, "round는 필수값입니다.");
        Preconditions.checkNotNull(races, "races는 필수값입니다.");

        this.round = round;
        this.races = races;
    }

    public static RaceResult of(Round round, List<Race> races) {
        return new RaceResult(round, races);
    }

    public Round getCurrentRound() {
        return round;
    }

    public List<Race> getRaces() {
        return races;
    }

    public static class Race {
        private final String carName;
        private final Position position;

        private Race(String carName, Position position) {
            Preconditions.checkNotNull(carName, "carName은 필수값입니다.");
            Preconditions.checkNotNull(position, "position는 필수값입니다.");

            this.carName = carName;
            this.position = position;
        }

        public static Race of(String carName, Position position) {
            return new Race(carName, position);
        }

        public String getCarName() {
            return carName;
        }

        public Position getCurrentPosition() {
            return position;
        }
    }
}
package racingcar.domain.response;

import java.util.List;
import java.util.Objects;

public class RacingGamePlayResponse {

    private final List<String> winnerNames;
    private final List<RacingGameRoundResponse> racingGameRoundResponses;

    public RacingGamePlayResponse(List<String> winnerNames, List<RacingGameRoundResponse> racingGameRoundResponses) {
        this.winnerNames = winnerNames;
        this.racingGameRoundResponses = racingGameRoundResponses;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public List<RacingGameRoundResponse> getRacingGameRoundResponses() {
        return racingGameRoundResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingGamePlayResponse)) {
            return false;
        }
        RacingGamePlayResponse response = (RacingGamePlayResponse) o;
        return Objects.equals(winnerNames, response.winnerNames) && Objects.equals(
            racingGameRoundResponses, response.racingGameRoundResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNames, racingGameRoundResponses);
    }

    @Override
    public String toString() {
        return "RacingGamePlayResponse{" +
            "winnerNames=" + winnerNames +
            ", racingGameRoundResponses=" + racingGameRoundResponses +
            '}';
    }

    public static class RacingGameRoundResponse {

        private final int round;
        private final List<CarPerRoundResponse> carPerRoundResponses;

        public List<CarPerRoundResponse> getCarPerRoundResponses() {
            return carPerRoundResponses;
        }

        public RacingGameRoundResponse(int round, List<CarPerRoundResponse> carPerRoundResponses) {
            this.round = round;
            this.carPerRoundResponses = carPerRoundResponses;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RacingGameRoundResponse)) {
                return false;
            }
            RacingGameRoundResponse that = (RacingGameRoundResponse) o;
            return round == that.round && Objects.equals(carPerRoundResponses, that.carPerRoundResponses);
        }

        @Override
        public int hashCode() {
            return Objects.hash(round, carPerRoundResponses);
        }

        @Override
        public String toString() {
            return "RacingGameRoundResponse{" +
                "round=" + round +
                ", carPerRoundResponses=" + carPerRoundResponses +
                '}';
        }
    }

    public static class CarPerRoundResponse {

        private final String name;
        private final int position;

        public CarPerRoundResponse(String name, int position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof CarPerRoundResponse)) {
                return false;
            }
            CarPerRoundResponse that = (CarPerRoundResponse) o;
            return position == that.position && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, position);
        }

        @Override
        public String toString() {
            return "CarPerRoundResponse{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
        }
    }

}

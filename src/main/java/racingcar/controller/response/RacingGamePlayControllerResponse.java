package racingcar.controller.response;

import racingcar.usecase.response.RacingGamePlayResponse;
import racingcar.usecase.response.RacingGamePlayResponse.CarPerRoundResponse;
import racingcar.usecase.response.RacingGamePlayResponse.RacingGameRoundResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGamePlayControllerResponse {

    private final List<String> winnerNames;
    private final List<RacingGamePlayControllerRoundResponse> racingGameRoundResponses;

    public RacingGamePlayControllerResponse(RacingGamePlayResponse racingGamePlayResponse) {
        winnerNames = racingGamePlayResponse.getWinnerNames();
        racingGameRoundResponses = getRoundResponse(racingGamePlayResponse.getRacingGameRoundResponses());
    }

    private List<RacingGamePlayControllerRoundResponse> getRoundResponse(
        List<RacingGameRoundResponse> racingGameRoundResponses) {
        return racingGameRoundResponses.stream()
            .map(r -> new RacingGamePlayControllerRoundResponse(r.getRound(),
                getCarPerRoundResponse(r.getCarPerRoundResponses())))
            .collect(Collectors.toList());
    }

    private List<ControllerCarPerRoundResponse> getCarPerRoundResponse(List<CarPerRoundResponse> carPerRoundResponses) {
        return carPerRoundResponses.stream()
            .map(cp -> new ControllerCarPerRoundResponse(cp.getName(), cp.getPosition()))
            .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public List<RacingGamePlayControllerRoundResponse> getRacingGameRoundResponses() {
        return racingGameRoundResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingGamePlayControllerResponse)) {
            return false;
        }
        RacingGamePlayControllerResponse that = (RacingGamePlayControllerResponse) o;
        return Objects.equals(winnerNames, that.winnerNames) && Objects.equals(racingGameRoundResponses,
            that.racingGameRoundResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNames, racingGameRoundResponses);
    }

    @Override
    public String toString() {
        return "RacingGamePlayControllerResponse{" +
            "winnerNames=" + winnerNames +
            ", racingGameRoundResponses=" + racingGameRoundResponses +
            '}';
    }

    public static class RacingGamePlayControllerRoundResponse {

        private final int round;
        private final List<ControllerCarPerRoundResponse> carPerRoundResponses;

        private RacingGamePlayControllerRoundResponse(int round,
            List<ControllerCarPerRoundResponse> carPerRoundResponses) {
            this.round = round;
            this.carPerRoundResponses = carPerRoundResponses;
        }

        public List<ControllerCarPerRoundResponse> getCarPerRoundResponses() {
            return carPerRoundResponses;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RacingGamePlayControllerRoundResponse)) {
                return false;
            }
            RacingGamePlayControllerRoundResponse that = (RacingGamePlayControllerRoundResponse) o;
            return round == that.round && Objects.equals(carPerRoundResponses, that.carPerRoundResponses);
        }

        @Override
        public int hashCode() {
            return Objects.hash(round, carPerRoundResponses);
        }

        @Override
        public String toString() {
            return "RacingGamePlayControllerRoundResponse{" +
                "round=" + round +
                ", carPerRoundResponses=" + carPerRoundResponses +
                '}';
        }
    }

    public static class ControllerCarPerRoundResponse {

        private final String name;
        private final int position;

        private ControllerCarPerRoundResponse(String name, int position) {
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
            if (!(o instanceof ControllerCarPerRoundResponse)) {
                return false;
            }
            ControllerCarPerRoundResponse that = (ControllerCarPerRoundResponse) o;
            return position == that.position && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, position);
        }

        @Override
        public String toString() {
            return "ControllerCarPerRoundResponse{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
        }
    }

}

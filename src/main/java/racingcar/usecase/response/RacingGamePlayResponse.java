package racingcar.usecase.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingGamePlayResponse {

    private String[] winnerNames;
    private List<RacingGameRoundResponse> racingGameRoundResponses;

    public RacingGamePlayResponse() {
        racingGameRoundResponses = new ArrayList<>();
    }

    public void addRacingGameRoundResponse(int round, Car... cars) {
        RacingGameRoundResponse racingGameRoundResponse = new RacingGameRoundResponse(round, Arrays.stream(cars)
            .map(c -> new CarPerRoundResponse(c.getName(), c.getPosition()))
            .collect(Collectors.toList())
        );
        racingGameRoundResponses.add(racingGameRoundResponse);
    }

    private static class RacingGameRoundResponse {

        private final int round;
        private final List<CarPerRoundResponse> carPerRoundResponses;

        private RacingGameRoundResponse(int round, List<CarPerRoundResponse> carPerRoundResponses) {
            this.round = round;
            this.carPerRoundResponses = carPerRoundResponses;
        }

    }

    private static class CarPerRoundResponse {

        private final String name;
        private final int position;

        private CarPerRoundResponse(String name, int position) {
            this.name = name;
            this.position = position;
        }
    }

}

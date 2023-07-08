package racingcar.usecase;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

import java.util.stream.Collectors;

public class RacingGamePlayUsecase {

    public RacingGamePlayResponse play(int round, RacingGamePlayRequest racingGamePlayRequest) {
        Cars cars = createRacingGame(racingGamePlayRequest);
        RacingGamePlayResponse response = new RacingGamePlayResponse();
        response.addRacingGameRoundResponse(0, cars.getRoundResult());

        playAllRound(round, cars, response);

        response.setWinner(cars.getWinners());
        return response;
    }

    private Cars createRacingGame(RacingGamePlayRequest racingGamePlayRequest) {
        return new Cars(racingGamePlayRequest.getCarRequests().stream()
                .map(cr -> new Car(cr.getName(), cr.getMoveable()))
                .collect(Collectors.toList())
        );
    }

    private void playAllRound(int round, Cars cars, RacingGamePlayResponse response) {
        for (int currentRound = 1; currentRound <= round; currentRound++) {
            response.addRacingGameRoundResponse(currentRound, cars.playOneRound());
        }
    }

}

package racingcar.usecase;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

import java.util.stream.Collectors;

public class RacingGamePlayUsecase {

    public RacingGamePlayResponse play(int round, RacingGamePlayRequest racingGamePlayRequest) {
        RacingGame racingGame = getRacingGame(racingGamePlayRequest);
        RacingGamePlayResponse response = new RacingGamePlayResponse();
        response.addRacingGameRoundResponse(0, racingGame.getRoundResult());

        playRound(round, racingGame, response);

        response.setWinner(racingGame.getWinners());
        return response;
    }

    private RacingGame getRacingGame(RacingGamePlayRequest racingGamePlayRequest) {
        return new RacingGame(racingGamePlayRequest.getCarRequests().stream()
                .map(cr -> new Car(cr.getName(), cr.getMoveable()))
                .collect(Collectors.toList())
        );
    }

    private void playRound(int round, RacingGame racingGame, RacingGamePlayResponse response) {
        for (int currentRound = 1; currentRound <= round; currentRound++) {
            racingGame.play();
            response.addRacingGameRoundResponse(currentRound, racingGame.getRoundResult());
        }
    }

}

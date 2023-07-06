package racingcar.usecase;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

public class RacingGamePlayUsecase implements RacingGamePlayable {

    private static final int ROUND_OFFSET = 0;
    private static final int PLAYED_ROUND_OFFSET = 1;

    @Override
    public RacingGamePlayResponse play(int round, RacingGamePlayRequest racingGamePlayRequest) {
        RacingGame racingGame = getRacingGame(racingGamePlayRequest);
        RacingGamePlayResponse response = new RacingGamePlayResponse();
        response.addRacingGameRoundResponse(ROUND_OFFSET, racingGame.getRoundResult());

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
        for (int currentRound = PLAYED_ROUND_OFFSET; currentRound <= round; currentRound++) {
            racingGame.play();
            response.addRacingGameRoundResponse(currentRound, racingGame.getRoundResult());
        }
    }

}

package racingcar.usecase;

import racingcar.domain.RacingGame;
import racingcar.usecase.response.RacingGamePlayResponse;

public class RacingGamePlayUsecase {

    public RacingGamePlayResponse play(int round, RacingGame racingGame) {
        RacingGamePlayResponse response = new RacingGamePlayResponse();
        response.addRacingGameRoundResponse(0, racingGame.getRoundResult());

        playRound(round, racingGame, response);

        response.setWinner(racingGame.getWinners());
        return response;
    }

    private void playRound(int round, RacingGame racingGame, RacingGamePlayResponse response) {
        for (int currentRound = 1; currentRound <= round; currentRound++) {
            racingGame.play();
            response.addRacingGameRoundResponse(currentRound, racingGame.getRoundResult());
        }
    }

}

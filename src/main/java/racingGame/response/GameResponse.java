package racingGame.response;

import racingGame.model.GameResult;
import racingGame.model.JoinCars;

public record GameResponse(GameResult gameResult, JoinCars winners) {

}

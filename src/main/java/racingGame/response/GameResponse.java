package racingGame.response;

import java.util.List;
import racingGame.model.Car;
import racingGame.model.GameResult;

public record GameResponse(GameResult gameResult, List<Car> winners) {

}

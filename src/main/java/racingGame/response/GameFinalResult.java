package racingGame.response;

import java.util.List;
import racingGame.model.Car;

public record GameFinalResult(List<GameResult> gameResult, List<Car> winners) {
    
}

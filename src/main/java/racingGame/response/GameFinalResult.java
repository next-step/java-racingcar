package racingGame.response;

import java.util.List;

public record GameFinalResult(List<GameResult> gameResult, List<String> winners) {
    
}

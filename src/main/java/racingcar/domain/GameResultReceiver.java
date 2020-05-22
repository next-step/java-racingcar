package racingcar.domain;

import java.util.List;

public interface GameResultReceiver {
    void notifyFinishRace(List<RacingScoreCard> racingScoreCards);
}

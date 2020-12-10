package racing;

import racing.car.RacingCarGroup;

import java.util.List;

public interface RacingNotifier {
	void notifyRace(RacingCarGroup racingCarGroup);
	void notifyWinner(List<String> winnerNameList);
}

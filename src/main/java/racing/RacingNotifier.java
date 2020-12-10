package racing;

import racing.car.CarName;
import racing.car.RacingCarGroup;

import java.util.List;

public interface RacingNotifier {
	void notifyRace(RacingCarGroup racingCarGroup);
	void notifyWinner(List<CarName> winnerNameList);
}

package racing;

import racing.car.CarGroup;

import java.util.List;

public interface RacingNotifier {
	void notifyRace(CarGroup carGroup);
	void notifyWinner(List<String> winnerNameList);
}

package racing.view;

import racing.RacingNotifier;
import racing.car.RacingCar;
import racing.car.RacingCarGroup;

import java.util.List;
import java.util.stream.Collectors;

public class RacingNotifyView implements RacingNotifier {

	private static final String POSITION_WORD = "-";

	@Override
	public void notifyRace(RacingCarGroup racingCarGroup) {
		List<String> positions = racingCarGroup.stream()
				.map(RacingNotifyView::createCarStatusAsString)
				.collect(Collectors.toList());

		String allPosition = String.join("\n", positions);
		System.out.println(String.format("%s\n", allPosition));
	}

	@Override
	public void notifyWinner(List<String> winnerNameList) {
		if (winnerNameList.isEmpty()) {
			throw new IllegalArgumentException("우승자가 없습니다");
		}

		String winnerNames = String.join(", ", winnerNameList);
		String msg = String.format("%s가 최종 우승 했습니다.", winnerNames);
		System.out.print(msg);
	}

	private static String createCarStatusAsString(RacingCar racingCar) {
		String carName = racingCar.getCarName();
		String position = getPositionAsString(racingCar.getPosition());
		return String.format("%s : %s", carName, position);
	}

	private static String getPositionAsString(int position) {
		StringBuilder positionString = new StringBuilder();
		for (int i = 0; i < position; i++) {
			positionString.append(POSITION_WORD);
		}
		return positionString.toString();
	}
}

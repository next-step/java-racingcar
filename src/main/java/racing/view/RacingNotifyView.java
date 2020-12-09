package racing.view;

import racing.RacingNotifier;
import racing.car.Car;
import racing.car.CarGroup;

import java.util.List;
import java.util.stream.Collectors;

public class RacingNotifyView implements RacingNotifier {

	private static final String POSITION_WORD = "-";

	@Override
	public void notifyRace(CarGroup carGroup) {
		List<String> positions = carGroup.stream()
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

	private static String createCarStatusAsString(Car car) {
		String carName = car.getCarName();
		String position = getPositionAsString(car.getPosition());
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

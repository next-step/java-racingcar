package racing;

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

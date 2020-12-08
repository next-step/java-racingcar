package racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingNotifyView implements RacingNotifier {

	private static final String POSITION_WORD = "-";

	@Override
	public void notifyRace(RacingStatus racingStatus) {
		List<String> positions = racingStatus.getCarList().stream()
				.map(car -> getPositionAsString(car.getPosition()))
				.collect(Collectors.toList());

		String allPosition = String.join("\n", positions);
		System.out.println(String.format("%s\n", allPosition));
	}

	private static String getPositionAsString(int position) {
		StringBuilder positionString = new StringBuilder();
		for (int i = 0; i < position; i++) {
			positionString.append(POSITION_WORD);
		}
		return positionString.toString();
	}
}

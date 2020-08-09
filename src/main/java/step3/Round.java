package step3;

import java.util.List;
import java.util.Random;

public class Round {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_LIMIT = 9;
	private static final String MOVE_MARK = "-";

	private static StringBuilder roundScoreRecord = new StringBuilder();

	public static StringBuilder getRoundScoreRecord() {
		return roundScoreRecord;
	}

	public static void play(List<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).moveForward(getRanDomNumber());
			saveRoundScore(cars.get(i));
		}
		roundScoreRecord.append(System.lineSeparator());
	}

	private static void saveRoundScore(Car car) {
		for (int i = 0; i < car.getRecord(); i++) {
			roundScoreRecord.append(MOVE_MARK);
		}
		roundScoreRecord.append(System.lineSeparator());
	}

	private static int getRanDomNumber() {
		return RANDOM.nextInt(RANDOM_LIMIT);
	}

}

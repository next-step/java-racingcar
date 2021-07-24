package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

	private final List<Car> cars;
	private final Validation validation;
	private final Random random;
	private final MessageBox messageBox;
	private int MAX_VALUE = 0;

	public Racing(MessageBox messageBox) {
		cars = new ArrayList<>();
		validation = new Validation();
		random = new Random();
		this.messageBox = messageBox;
	}

	public List<Car> createPlayer(String playerListValue) {
		String[] playerArray = playerListValue.split(",");
		validation.validStringEmpty(playerListValue.trim());
		return setupPlayer(playerArray);
	}

	public List<Car> setupPlayer(String[] playerArray) {
		for (String playerName : playerArray) {
			Car car = new Car(playerName, validation);
			cars.add(car);
		}
		return cars;
	}

	public void playingGame(String inputValue) {
		int tryGameCount = toInt(inputValue);
		messageBox.resultMessage();
		for (int i = 0; i < tryGameCount; i++) {
			carRacing();
		}
		String winnerPlayer = winnerPlayer().trim();
		messageBox.winnerMessageBox(winnerPlayer.substring(0, winnerPlayer.length() - 1));
	}

	public int toInt(String value) {
		validation.validNumberCheck(value);
		return Integer.parseInt(value);
	}

	private void carRacing() {
		for (Car car : cars) {
			int resultRacing = car.carRacing(randomValue());
			maxValueCheck(resultRacing);
			messageBox.racingResultMessage(car.getCarName(), resultRacing);
		}
		messageBox.commonMessageBox("");
	}

	private void maxValueCheck(int resultValue) {
		if (MAX_VALUE < resultValue) {
			MAX_VALUE = resultValue;
		}
	}

	public int randomValue() {
		int RANDOM_VALUE = 10;
		return random.nextInt(RANDOM_VALUE);
	}

	public String winnerPlayer() {
		StringBuilder winnerResult = new StringBuilder();
		for (Car car : cars) {
			winnerResult.append(car.searchWinner(MAX_VALUE));
		}
		return winnerResult.toString();
	}
}

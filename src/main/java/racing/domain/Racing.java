package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import racing.domain.Car;
import racing.view.MessageBox;

public class Racing {

	public static final int RANDOM_VALUE = 10;
	private final List<Car> cars;
	private final Random random;
	private final MessageBox messageBox;
	private int MAX_VALUE = 0;

	public Racing(MessageBox messageBox) {
		cars = new ArrayList<>();
		random = new Random();
		this.messageBox = messageBox;
	}

	public List<Car> createPlayer(String playerListValue) {
		String[] playerArray = playerListValue.split(",");
		validStringEmpty(playerListValue.trim());
		return setupPlayer(playerArray);
	}

	private void validStringEmpty(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 한다.");
		}
	}

	private List<Car> setupPlayer(String[] playerArray) {
		for (String playerName : playerArray) {
			Car car = new Car(playerName);
			cars.add(car);
		}
		return cars;
	}

	public void playingGame(String inputValue) {
		int tryGameCount = toInt(inputValue);
		messageBox.resultMessage();
		carRacing(tryGameCount);
		messageBox.winnerMessageBox(winnerPlayer().substring(0, winnerPlayer().length() - 1));
	}

	public int toInt(String value) {
		validNumberCheck(value);
		return Integer.parseInt(value);
	}

	private void validNumberCheck(String value) {
		String regExp = "^\\d+$";
		if (!value.matches(regExp)) {
			throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
		}
	}

	public void carRacing(int tryGameCount) {
		for (int i = 0; i < tryGameCount; i++) {
			carsRaceForResult();
			messageBox.MessageBoxNextLine();
		}
	}

	private void carsRaceForResult() {
		for (Car car : cars) {
			int resultRacing = car.carMove(randomValue());
			maxValueCheck(resultRacing);
			messageBox.racingResultMessage(car.getCarName(), getRacingResultByString(resultRacing));
		}
	}

	public String getRacingResultByString(int racingResult) {
		StringBuilder result = new StringBuilder(racingResult);
		for (int i = 0; i < racingResult; i++) {
			result.append("-");
		}
		return result.toString();
	}

	private void maxValueCheck(int resultValue) {
		if (MAX_VALUE < resultValue) {
			MAX_VALUE = resultValue;
		}
	}

	public int randomValue() {
		return random.nextInt(RANDOM_VALUE);
	}

	public String winnerPlayer() {
		StringBuilder winnerResult = new StringBuilder();
		for (Car car : cars) {
			winnerResult.append(searchWinner(car.resultRacing(), car.getCarName()));
		}
		return winnerResult.toString();
	}

	public String searchWinner(int carRacingResult, String carName) {
		StringBuilder winnerName = new StringBuilder();
		if (carRacingResult == MAX_VALUE) {
			winnerName.append(carName);
			winnerName.append(",");
		}
		return winnerName.toString();
	}
}

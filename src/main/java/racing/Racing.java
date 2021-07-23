package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Racing {

	private final List<Car> cars;
	private final Validation validation;
	private final Random random;
	private final MessageBox messageBox;
	private final StringBuffer winnerPlayList;
	private  int MAX_VALUE = 0;

	public Racing(MessageBox messageBox) {
		cars = new ArrayList<>();
		validation = new Validation();
		random = new Random();
		winnerPlayList = new StringBuffer();
		this.messageBox = messageBox;
	}

	public List<Car> createPlayer(String playerListValue) {
		String[] playerArray = playerListValue.split(",");
		validation.validStringEmpty(playerListValue.trim());
		return setupPlayer(playerArray);
	}

	public List<Car> setupPlayer(String[] playerArray) {
		int CHECK_LENGTH = 4;
		for (String playerName : playerArray) {
			validation.validStringLength(playerName, CHECK_LENGTH);
			Car car = new Car(playerName);
			cars.add(car);
		}
		return cars;
	}

	public void playingGame(String inputValue) {
		validation.validNumberCheck(inputValue);
		int tryGameCount = toInt(inputValue);
		messageBox.commonMessageBox("실행 결과");
		for (int i = 0; i < tryGameCount; i++) {
			gamePlay();
		}
		String WINNER_MESSAGE = " 가 최종 우승했습니다.";
		String winnerPlayer = winnerPlayer().trim();
		messageBox.commonMessageBox(winnerPlayer.substring(0,winnerPlayer.length()-1), WINNER_MESSAGE);
	}

	public int toInt(String value) {
		return Integer.parseInt(value);
	}

	private void gamePlay() {
		for (Car car : cars) {
			int resultRacing = car.carRacing(randomValue());
			maxValueCheck(resultRacing);
			messageBox.racingResultMessage(car.getCarName(), resultRacing);
		}
		messageBox.commonMessageBox("");
	}

	private void maxValueCheck(int resultValue){
		if(MAX_VALUE < resultValue){
			MAX_VALUE = resultValue;
		}
	}

	public int randomValue() {
		int RANDOM_VALUE = 10;
		return random.nextInt(RANDOM_VALUE);
	}

	public String winnerPlayer() {
		for(Car car : cars){
			winnerConfirm(car.searchWinner(MAX_VALUE));
		}
		return winnerPlayList.toString();
	}



	private void winnerConfirm(String playerName) {
		if(!playerName.isEmpty()){
			winnerPlayList.append(playerName);
			winnerPlayList.append(",");
		}
	}
}

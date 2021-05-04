package domain;

import java.util.List;

public class Race {
	public static void main(String[] args) {
		Race.startGame();
	}

	public static void startGame() {
		User user = new User();
		user.setCarList();
		user.setRepeatTime();
		List<Racingcar> racingcarList = RacingcarList.getRacingcarStringToList(user.getCarList());
		RacingcarList.printRaceResult(racingcarList, user.getRepeatTime());
	}
}

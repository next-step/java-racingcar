package racing;

public class Car {

	private static final int CHECK_LENGTH = 4;
	private final String carName;
	private int raceDistance;

	public Car(String carName, Validation validation) {
		validation.validStringLength(carName, CHECK_LENGTH);
		this.carName = carName;
	}

	public int carRacing(int value) {
		return carMoveCheck(value);
	}

	public int carMoveCheck(int value){
		if (value > 3) {
			return ++raceDistance;
		}
		return raceDistance;
	}

	public String getCarName() {
		return carName;
	}

	public String searchWinner(int winnerScore) {
		String winnerName = "";
		if (raceDistance == winnerScore) {
			winnerName = winnerName.concat(carName+",");
		}
		return winnerName;
	}

}

package racing;

public class Car {

	private static final int CHECK_LENGTH = 4;
	private final String carName;
	private int raceDistance;

	public Car(String carName) {
		validStringLength(carName);
		this.carName = carName;
	}

	public void validStringLength(String value) {
		if (value.length() > CHECK_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5글자를 초과할수 없습니다.");
		}
	}

	public int carRacing(int value) {
		 carMoveCheck(value);
		 return raceDistance;
	}

	public void carMoveCheck(int value){
		if (value > 3) {
			++raceDistance;
		}
	}

	public String getCarName() {
		return carName;
	}

	public int resultRacing(){
		return raceDistance;
	}

}

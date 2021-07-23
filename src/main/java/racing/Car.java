package racing;

public class Car {

	private final String carName;
	private int raceDistance;

	public Car(String carName) {
		this.carName = carName;
	}

	public int carRacing(int value) {
		if (value > 3) {
			return ++raceDistance;
		}
		return raceDistance;
	}

	public String getCarName() {
		return carName;
	}

	public String searchWinner(int winnerScore){
		if(raceDistance == winnerScore){
			return carName;
		}
		return "fail";
	}

}

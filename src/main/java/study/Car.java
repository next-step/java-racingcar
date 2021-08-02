package study;

public class Car {

	private int distance;
	private static int RACE_WIN_RANGE = 4;

	public Car(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void move(int randomNumber) {
		if(randomNumber >= RACE_WIN_RANGE) {
			distance += 1;
		}
	}
}

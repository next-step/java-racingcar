package racing;

public class Racer {

	private StringBuilder currentLocation;
	private int racerNumber;

	public Racer(int number) {
		this.currentLocation = new StringBuilder();
		this.racerNumber = number;
	}

	public void goStraight() {
		this.currentLocation.append("-");
	}

	public String getCurrentLocation() {
		return this.currentLocation.toString();
	}

	public int getRacerNumber() {
		return this.racerNumber;
	}

}

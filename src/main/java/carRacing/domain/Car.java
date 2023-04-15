package carRacing.domain;

public class Car {

	private int location;

	public void move(int randomValue) {
		if (randomValue >= 4) {
			this.location += 1;
		}
	}

	public int getLocation() {
		return this.location;
	}
}

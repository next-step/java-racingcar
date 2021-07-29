package refactoring.domain;

public class CarDistance {

	private int distance;

	public CarDistance() {
		this.distance = 0;
	}

	public void increaseDistance() {
		distance++;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		CarDistance carDistance = (CarDistance) obj;

		return distance == carDistance.distance;
	}
}

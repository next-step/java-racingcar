package racingGame.domain;

public class Car {
	private String racer;
	private int distance;
	private Engine engine;

	public Car(String racer, Engine engine) {
		this.racer = racer;
		this.engine = engine;
	}

	public String getRacer() {
		return racer;
	}

	public int getDistance() {
		return distance;
	}

	void move() {
		distance += engine.moveDistanceForOneTime();
	}

	boolean isSameDistance(int expectedDistance) {
		return this.distance == expectedDistance;
	}
}

package racingGame.domain;

public class Car {
	private String racer;
	private int distance;
	private Engine engine;

	public Car(String racer, Engine engine) {
		this.racer = racer;
	}

	public String getRacer() {
		return racer;
	}

	public int getDistance() {
		return distance;
	}

	int move(){
		//todo 움직임 로직... 현재 distance 에 적용하고 리턴 할 것.
		return distance++;
	}
}

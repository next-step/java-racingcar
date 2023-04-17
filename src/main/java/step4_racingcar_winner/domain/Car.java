package step4_racingcar_winner.domain;

public class Car {

	private String name;
	private int position = 0;

	public Car(String name)
	{
		this.name = name;
	}
	public void tryMove(boolean isMovable) {
		if (isMovable) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}

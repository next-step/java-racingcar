package study.racingcar.domain;

public class Car {

	private final Position position;
	private final Name name;

	public Car(String name) {
		this.position = new Position();
		this.name = new Name(name);
	}

	public int carPosition() {
		return this.position.valueOfPosition();
	}

	public void go(boolean isMoveCar) {
		if (isMoveCar) {
			this.position.add();
		}
	}

	public String carName(){
		return name.value();
	}

	public boolean isMaxPosition(int position){
		Position maxPosition = new Position(position);
		return this.position.equals(maxPosition);
	}

}

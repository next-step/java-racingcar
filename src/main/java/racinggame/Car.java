package racinggame;

/**
 * Created by hspark on 03/11/2018.
 */
public class Car {

	private int position;

	public Car() {
	}

	public Car(Car car) {
		this.position = car.position;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		position++;
	}

}

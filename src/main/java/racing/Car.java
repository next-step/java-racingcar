package racing;

class Car {

	private int position;

	Car() {
		this.position = 0;
	}

	void moveForward() {
		this.position++;
	}

	int getPosition() {
		return this.position;
	}
}

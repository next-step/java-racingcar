package step3;

public class Car {
	private int position;
	private static final int COUNT_ADVANCE = 1;
	private static final int COUNT_STOP = 0;

	public Car() {
		this.position = 0;
	}

	public int getPosition() {
		return this.position;
	}

	public void advance() {
		this.position = this.position + COUNT_ADVANCE;
	}

	public void stop() {
		this.position = this.position + COUNT_STOP;
	}
}

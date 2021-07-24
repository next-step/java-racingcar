package racingcar;

public class RacingCar {
	public int pos;

	public RacingCar() {
		this.pos = 0;
	}

	public int getPos() {
		return this.pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void forward() {
		pos += ( Util.generateForwardValue() >= 4 ) ? 1 : 0;
	}
}

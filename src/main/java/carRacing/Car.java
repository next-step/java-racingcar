package carRacing;

public class Car {

	private int position;
	private RandomNumMaker ran = new RandomNumMaker();

	public void moveCar() {
		if (ran.isAboveBoundary()){
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}

package carRacing;

public class Car {

	public int index = 0;
	private RandomNumMaker ran = new RandomNumMaker();

	public void moveCar() {
		if (ran.isAboveBoundary()){
			index++;
		}
	}
}

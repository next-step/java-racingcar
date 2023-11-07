package carRacing;

import java.util.Random;

public class Car {

	public int index = 0;
	private RandomNumMaker ran = new RandomNumMaker();
	public boolean isRanNumAboveFour = ran.isAboveBoundary();

	public void moveCar(boolean isRanNumAboveFour) {
		if (isRanNumAboveFour) {
			index++;
		}
	}
}

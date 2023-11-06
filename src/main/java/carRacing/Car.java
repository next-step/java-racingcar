package carRacing;

import java.util.Random;

public class Car {

	private int index = 0;
	private Random random = new Random();
	private int randomNum = random.nextInt(10);

	public int moveCar(int randomNum) {
		if (randomNum >= 4) {
			index++;
		}
		return index;
	}
}

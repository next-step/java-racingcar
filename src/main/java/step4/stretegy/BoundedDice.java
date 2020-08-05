package step4.stretegy;

import java.util.Random;

public class BoundedDice {

	private final int bound;

	private Random dice = new Random();

	public BoundedDice(int bound) {
		this.bound = bound;
	}

	public int rollDice()  {
		return dice.nextInt(bound);
	}
}

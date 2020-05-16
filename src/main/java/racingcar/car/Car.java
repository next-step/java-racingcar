package racingcar.car;

import java.util.Random;

public class Car {
	private int position;
	private int moveAbility;
	private String positionSymbol;
	private String name;

	public Car(String name) {
		this(1, 1, name);
	}
	
	public Car(int position , int ability , String name) {
		this.position = position;
		this.moveAbility = ability;
		this.positionSymbol ="";
		this.name = name;
	}
	
	public void move(int power) {

		Random random = new Random();
		int randomCount = random.nextInt(10);
		
		if (randomCount > power) {
			position += moveAbility;
		}

	}

	public int getPosition() {
		return this.position;
	}
}

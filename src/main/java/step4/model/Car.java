package step4.model;

import step4.util.NumberGenerator;
import step4.util.RandomNumberGenerator;

public class Car {
	private static final int MAX_BOUND = 10;
	private static final int MOVE_STANDARD_NUMBER = 4;
	private static final NumberGenerator NUMBER_GENERATOR = new RandomNumberGenerator();

	private final String name;
	private int moveCnt;

	public Car(String name) {
		checkNameCondition(name);
		this.name = name;
		this.moveCnt = 0;
	}

	public int getMoveCnt() {
		return moveCnt;
	}
	public String getName(){
		return name;
	}

	public void checkNameCondition(String name){
		if(name.length() > 5) throw new RuntimeException("이름의 길이는 5자 이상 초과되면 안됩니다.");
	}
	public void move(){
		int generateNumber = NUMBER_GENERATOR.generateNumber(MAX_BOUND);
		if (generateNumber > MOVE_STANDARD_NUMBER) 	moveCnt += 1;
	}
}

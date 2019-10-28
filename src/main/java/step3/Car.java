package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
	private String name;
	private int position;
	private List<Integer> positionList = new ArrayList<>();
	private boolean isWinner = false;

	private Random rnd = new Random();
	private final int RANDOM_BOUND = 10;
	private final int MOVE_THRESHOLD = 4;

	public Car(String name) {
		this.name = name;
		positionList.add(position);
	}

	public void move() {
		if (canMove()) {
			position++;
		}
		positionList.add(position);
	}

	private boolean canMove() {
		return rnd.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getPositionList() {
		return positionList;
	}

	public int getPosition() {
		return position;
	}

	public void setIsWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public boolean getIsWinner() {
		return isWinner;
	}
}

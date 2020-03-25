package racing.object;

import java.util.Random;

public class Car implements Comparable {
	
	private static final int RANDOM_LIMIT = 10;
	private static final int IS_CASE_FORWARD_MIN = 4;
	private static final int FORWARD_UNIT = 1;
	
	private String name = "";
	private int position = 0;
	
	public Car(String name) {
		this.name = name;
	}
	
	public void move() {
		position += isCaseForward() ? FORWARD_UNIT : 0;
	}
	
	private boolean isCaseForward() {
		Random random = new Random();
		return random.nextInt(RANDOM_LIMIT) >= IS_CASE_FORWARD_MIN;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return position;
	}
	
	@Override
	public int compareTo(Object that) {
		return Integer.compare(this.getPosition(), ((Car) that).getPosition());
	}
}

package racing.domain.object;

import racing.utils.StringUtils;

public class Car {
	
	private final String name;
	private int position;
	
	public Car(String name) {
		this(name, 0);
	}
	
	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}
	
	public void move(int forwardPosition) {
		position += forwardPosition;
	}
	
	public boolean isWinner(int winnerPosition) {
		return position >= winnerPosition;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return position;
	}

	private String getPositionString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < position; ++i) {
			result.append("-");
		}
		return result.toString();
	}

	@Override
	public boolean equals(Object that) {
		return StringUtils.equals(this.name, ((Car)that).name);
	}

	@Override
	public String toString() {
		return name + " : " + getPositionString();
	}
}

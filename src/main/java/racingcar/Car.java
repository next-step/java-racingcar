package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private int position;
	private List<Integer> status = new ArrayList();

	public int getPosition() {
		return this.position;
	}

	public void move() {
		this.position += 1;
	}

	public void save() {
		status.add(getPosition());
	}

	public List<Integer> getStatus() {
		return this.status;
	}
}

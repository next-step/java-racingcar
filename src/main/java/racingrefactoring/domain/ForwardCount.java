package racingrefactoring.domain;

public class ForwardCount {

	private int count;

	public ForwardCount() {
		this(0);
	}

	public ForwardCount(int count) {
		if (count < 0) {
			throw new IllegalArgumentException();
		}
		this.count = count;
	}

	public void increase() {
		count++;
	}

	public boolean isPositive() {
		return greatThan(0);
	}

	public boolean greatThan(int value) {
		return count > value;
	}

	public int count() {
		return count;
	}

}

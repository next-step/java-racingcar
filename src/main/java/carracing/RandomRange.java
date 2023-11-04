package carracing;

public class RandomRange {
	private final int min;
	private final int max;

	public RandomRange(int max) {
		this(0, max);
	}

	public RandomRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int intValue() {
		return (int) (Math.random() * (max - min + 1)  + min);
	}
}

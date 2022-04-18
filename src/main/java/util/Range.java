package util;

public class Range<N extends Number> {
	private final N start;
	private final N end;

	private Range(N start, N end) {
		this.start = start;
		this.end = end;
	}

	public static <N extends Number> Range<?> of(N start, N end) {
		return new Range<>(start, end);
	}

	public <N extends Number> boolean contain(N target) {
		return start.doubleValue() <= target.doubleValue()
			&& target.doubleValue() <= end.doubleValue();
	}
}

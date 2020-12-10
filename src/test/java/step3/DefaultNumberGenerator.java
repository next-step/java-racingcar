package step3;

public class DefaultNumberGenerator implements NumberGenerator {
	public static DefaultNumberGenerator mustGoGenerator;
	private final int number;

	public DefaultNumberGenerator(int number) {
		this.number = number;
	}

	public static DefaultNumberGenerator getMustGoGenerator() {
		if (mustGoGenerator == null) {
			mustGoGenerator = new DefaultNumberGenerator(4);
		}

		return mustGoGenerator;
	}

	@Override
	public int generate() {
		return number;
	}
}

package step2;

public class LessThanZero extends Boolean {
	private final String input;

	public LessThanZero(String input) {
		this.input = input;
	}

	@Override
	public boolean satisfied() {
		return Integer.parseInt(input) < 0;
	}
}

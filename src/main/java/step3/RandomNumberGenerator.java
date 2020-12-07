package step3;

public class RandomNumberGenerator implements NumberGenerator {

	@Override
	public int generate() {
		return (int)(Math.random() * MAX_NUMBER_LESS_THAN);
	}
}

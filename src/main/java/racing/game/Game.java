package racing.game;

public class Game {
	private final RandomNextInt RANDOM;

	public Game(RandomNextInt randomNextInt) {
		RANDOM = randomNextInt;
	}

	public int bound() {
		return RANDOM.nextInt();
	}

	public int[] bounds(int length) {
		int[] bounds = new int[length];
		for (int i = 0; i < length; i++) {
			bounds[i] = bound();
		}
		return bounds;
	}

}

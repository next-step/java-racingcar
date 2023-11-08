package racing.game;

import java.util.Random;

public class RandomReturnZeroToNine extends Random {

	@Override
	public int nextInt() {
		return nextInt(10);
	}
}

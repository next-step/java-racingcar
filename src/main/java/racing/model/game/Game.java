package racing.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private final Random RANDOM;

	public Game(Random random) {
		RANDOM = random;
	}

	private int bound() {
		return RANDOM.nextInt();
	}

	public List<Integer> bounds(int length) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			result.add(bound());
		}
		return result;
	}

}

package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
	public int position;
	public static final int INITIAL_POSITION = 0;
	private static final int MOVABLE_MINIMUM_VALUE = 4;

	public RacingCar(int position) {
		this.position = position;
	}

	public String getRacingCarDashString() {
		return Arrays.stream(new String[this.position])
					 .map(s -> "-")
			         .collect(Collectors.joining(""));
	}

	public boolean isMovable(int randomValue) {
		return randomValue >= MOVABLE_MINIMUM_VALUE;
	}

	public void forward() {
		position++;
	}
}

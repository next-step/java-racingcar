package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
	public int position;
	public static final int INITIAL_POSITION = 0;

	public RacingCar(int position) {
		this.position = position;
	}

	public String getRacingCarDashString() {
		return Arrays.stream(new String[this.position])
					 .map(s -> "-")
			         .collect(Collectors.joining(""));
	}

	public boolean movable(int randomValue) {
		return randomValue >= 4;
	}

	public void forward() {
		position++;
	}
}

package racingcar.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCar {
	// https://velog.io/@kwj1270/JAVA-%EC%BD%94%EB%93%9C-%EC%BB%A8%EB%B2%A4%EC%85%98
	// 4. 클래스 변수(static) public -> protected -> package(default) -> private
	public static final int INITIAL_POSITION = 0;
	private static final int MOVABLE_MINIMUM_VALUE = 4;

	// 5. 일반 변수 public -> protected -> package(default) -> private
	public int position;

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

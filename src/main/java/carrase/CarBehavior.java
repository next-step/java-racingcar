package carrase;

import java.util.Arrays;

public enum CarBehavior {
	FORWARD(4, 9) {
		void apply(Car car) {
			car.moveForward();
		}
	},
	STOP(0, 3) {
		void apply(Car car) {
			car.stop();
		}
	};

	private final int min;
	private final int max;

	CarBehavior(int min, int max) {
		this.min = min;
		this.max = max;
	}

	abstract void apply(Car car);

	public static CarBehavior getCarBehavior(int number) throws IllegalArgumentException {
		return Arrays.stream(CarBehavior.values())
			.filter((behavior) -> behavior.min <= number && behavior.max >= number)
			.findFirst().orElseThrow(IllegalArgumentException::new);
	}
}

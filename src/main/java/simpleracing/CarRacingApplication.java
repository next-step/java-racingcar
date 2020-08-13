package simpleracing;

import simpleracing.domain.executor.CarRacingExecutor;

public class CarRacingApplication {

	public static void main(String[] args) {
		CarRacingExecutor executor = new CarRacingExecutor();
		executor.execute();
	}
}

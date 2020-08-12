package simpleracing.execute;

import java.util.List;

public class CarRacingGame implements CarGame {

	private Movable moving;

	public CarRacingGame() {
		this.moving = new RacingMoving();
	}

	@Override
	public void play(List<Car> cars) {
		cars.stream()
			.forEach(car -> {
				car.play(moving);
			});
	}

}

package racing.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

	@Test
	@DisplayName("경주에 경기 경과를 알 수 있다.")
	public void returnRacingResult() {
		Cars cars = racingMovedResult();
		Racing racing = Racing.raceStart(cars);
		Cars result = racing.carsRaceForResult();

		Assertions.assertThat(result.getInformation()).extracting("position.position").containsExactly(2, 3, 2);
	}

	@Test
	@DisplayName("경주에 최종승자를  알 수 있다.")
	public void returnWinners() {
		Cars cars = racingMovedResult();
		Racing racing = Racing.raceStart(cars);
		List<Car> winners = racing.winnerPlayer();

		Assertions.assertThat(winners).extracting("name.name").containsExactly("car2");
	}

	private Cars racingMovedResult() {
		Car car1 = new DummyCar("car1", 2);
		Car car2 = new DummyCar("car2", 3);
		Car car3 = new DummyCar("car3", 2);

		return new Cars(car1, car2, car3);
	}

	private static class DummyCar extends Car {
		public DummyCar(String carName, int position) {
			super(carName, position);
		}

		@Override
		public void move(RandomMoving randomMoving) {
			super.move(new DummyFalseRandomMove());
		}
	}

	private static class DummyFalseRandomMove extends RandomMoving{
		@Override
		public boolean movable(int randomValue) {
			return false;
		}
	}

}

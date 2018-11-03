package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private Car car;

	@Before
	public void setUp() {
		car = new Car();
	}

	@Test
	public void 이동_할수있을때_검증() {
		final int randomNumber = 4;
		assertMove(randomNumber, 1);
	}

	@Test
	public void 이동_못할때_검증() {
		final int randomNumber = 3;
		assertMove(randomNumber, 0);
	}

	@Test
	public void 여러번_이동_검증_모두_이동_가능() {
		final int randomNumber1 = 4;
		final int randomNumber2 = 5;

		assertMove(randomNumber1, 1);
		assertMove(randomNumber2, 2);
	}

	@Test
	public void 여러번_이동_검증_한번만_이동_가능() {
		final int randomNumber1 = 4;
		final int randomNumber2 = 3;

		assertMove(randomNumber1, 1);
		assertMove(randomNumber2, 1);
	}

	private void assertMove(int randomNumber, int expectedPosition) {
		int position = car.move(randomNumber);

		assertThat(position).isEqualTo(expectedPosition);
	}
}
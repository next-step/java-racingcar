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
		final int randomPosition = 4;
		assertMove(randomPosition, randomPosition);
	}

	@Test
	public void 이동_못할때_검증() {
		final int randomPosition = 3;
		assertMove(randomPosition, 0);
	}

	@Test
	public void 여러번_이동_검증_모두_이동_가능() {
		final int randomPosition1 = 4;
		final int randomPosition2 = 5;

		assertMove(randomPosition1, randomPosition1);
		assertMove(randomPosition2, randomPosition1 + randomPosition2);
	}

	@Test
	public void 여러번_이동_검증_한번만_이동_가능() {
		final int randomPosition1 = 4;
		final int randomPosition2 = 3;

		assertMove(randomPosition1, randomPosition1);
		assertMove(randomPosition2, randomPosition1);
	}

	private void assertMove(int randomPosition, int expected) {
		int position = car.move(randomPosition);

		assertThat(position).isEqualTo(expected);
	}
}
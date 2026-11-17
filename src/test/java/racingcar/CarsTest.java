package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 차3대_횟수1번일때_모두4이상나온경우() {
		Cars cars = new Cars(3);
		cars.play(() -> 4);
		assertThat(cars.getPositions()).containsExactly(1, 1, 1);
	}

}

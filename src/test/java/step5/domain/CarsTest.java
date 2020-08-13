package step5.domain;

import org.junit.jupiter.api.Test;
import step5.Always4Strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

	@Test
	void playRound() {
		Cars actual = new Cars("dam,dami,son,corgi");
		actual.playRound(new Always4Strategy());

		for (Car car : actual.getRacingCars()) {
			assertThat(car.getRecord()).isEqualTo(1);
		}

	}
}
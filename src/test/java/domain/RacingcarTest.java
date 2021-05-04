package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingcarTest {
	@Test
	public void constructorSingleParameterTest() {
		Racingcar actualRacingcar = new Racingcar("McLrn");
		assertThat(actualRacingcar.getCarName())
			.as("Failure - object are not equal: ")
			.isEqualTo("McLrn");
	}

	@Test
	public void constructorMultiParameterTest() {
		Racingcar actualRacingcar = new Racingcar("McLrn", "----------");
		assertThat(actualRacingcar.getCarName())
			.as("Failure - object are not equal: ")
			.isEqualTo("McLrn");
		assertThat(actualRacingcar.getCarPosition())
			.as("Failure - object are not equal: ")
			.isEqualTo("----------");
	}

	@Test
	public void moveForwardOrNotTest() {
		String move = Racingcar.moveForwardOrNot(4);
		String doNotMove = Racingcar.moveForwardOrNot(2);
		assertThat(move)
			.as("Failure - strings are not equal: ")
			.isEqualTo("-");
		assertThat(doNotMove)
			.as("Failure - strings are not equal: ")
			.isEqualTo("");
	}
}

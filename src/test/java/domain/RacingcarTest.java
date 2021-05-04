package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import util.InputView;

class RacingcarTest {
	private static final String TEST_TYPE_STRING = "STRING";
	private static final String TEST_TYPE_OBJECT = "OBJECT";

	@Test
	public void constructorSingleParameterTest() {
		Racingcar actualRacingcar = new Racingcar("McLrn");
		assertThat(actualRacingcar.getCarName())
			.as(InputView.getTestFailureMessage(TEST_TYPE_OBJECT))
			.isEqualTo("McLrn");
	}

	@Test
	public void constructorMultiParameterTest() {
		Racingcar actualRacingcar = new Racingcar("McLrn", "----------");
		assertThat(actualRacingcar.getCarName())
			.as(InputView.getTestFailureMessage(TEST_TYPE_OBJECT))
			.isEqualTo("McLrn");
		assertThat(actualRacingcar.getCarPosition())
			.as(InputView.getTestFailureMessage(TEST_TYPE_OBJECT))
			.isEqualTo("----------");
	}

	@Test
	public void moveForwardOrNotTest() {
		String move = Racingcar.moveForwardOrNot(4);
		String doNotMove = Racingcar.moveForwardOrNot(2);
		assertThat(move)
			.as(InputView.getTestFailureMessage(TEST_TYPE_STRING))
			.isEqualTo("-");
		assertThat(doNotMove)
			.as(InputView.getTestFailureMessage(TEST_TYPE_STRING))
			.isEqualTo("");
	}
}

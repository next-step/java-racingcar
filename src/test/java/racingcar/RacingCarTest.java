package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {
	RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar(RacingCar.INITIAL_POSITION);
	}

	@ParameterizedTest
	@CsvSource(value = { "0:false", "2:false", "4:true", "6:true", "8:true"}, delimiter = ':')
	void 주어진_인수를_입력받았을_때_4이상이면_전진가능하다(int forwardValue, boolean expected) {
		assertThat(racingCar.isMovable(forwardValue)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void 주어진_인수를_입력받았을_때_그_수_만큼_전진하다(int forwardValue) {
		for (int i = 0; i < forwardValue; i++ ) {
			racingCar.forward();
		}
		assertThat(racingCar.getRacingCarDashString()).isEqualTo(new String(new char[forwardValue]).replace("\0", "-"));
	}

}

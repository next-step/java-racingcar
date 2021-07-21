package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

	@ParameterizedTest(name = "전진 가능 여부 확인 {index} [{arguments}]")
	@CsvSource(value = {
			"4,true",
			"3,false"
	})
	void test(int randomValue, boolean expected) throws Exception {
		//given
		Car car = new Car();

		//when
		boolean b = car.canMoveForward(randomValue);

		//then
		assertThat(b).isEqualTo(expected);
	}
}

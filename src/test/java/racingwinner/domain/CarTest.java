package racingwinner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ragingwinner.domain.Car;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@ParameterizedTest(name = "전진 가능 여부 확인 {index} [{arguments}]")
	@CsvSource(value = {
			"4,true",
			"3,false"
	})
	void can_move_forward(int randomValue, boolean expected) throws Exception {
		//when
		boolean b = car.canMoveForward(randomValue);

		//then
		assertThat(b).isEqualTo(expected);
	}

	@Test
	@DisplayName("자동차 전진 여부는 랜덤에 의해 결정되기에 10회 전진 후 상태가 변화하였는지 확인")
	void forward() throws Exception {
		//then 초기 상태는 0
		assertThat(car.getForwardCount()).isZero();

		//when
		for (int i = 0; i < 10; i++) {
			car.moveForward();
		}

		//then
		assertThat(car.getForwardCount()).isNotZero();
	}

}

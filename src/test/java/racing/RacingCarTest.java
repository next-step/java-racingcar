package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.model.RacingCar;
import racing.model.service.ForwardCarConditional;
import racing.model.service.RandomCarConditional;
import racing.model.service.StopCarConditional;

class RacingCarTest {

	@Test
	@DisplayName("자동차 랜덤 레이스 움직임 구현")
	void RandomCarConditionalTest() {

		RacingCar car = new RacingCar();
		RandomCarConditional randomCarConditional = new RandomCarConditional();

		car.move(randomCarConditional);

		assertThat(car.getDistance()).isPositive();
	}

	@Test
	@DisplayName("자동차 랜덤 레이스 움직임 구현")
	void ForwardCarConditionalTest() {

		RacingCar car = new RacingCar();
		ForwardCarConditional forwardCarConditional = new ForwardCarConditional();

		car.move(forwardCarConditional);

		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 멈춤 전략 테스트 적용")
	void StopCarConditionalTest() {

		RacingCar car = new RacingCar();
		StopCarConditional stopCarConditional = new StopCarConditional();

		car.move(stopCarConditional);

		assertThat(car.getDistance()).isZero();
	}

	@Test
	@DisplayName("자동차 단일 객체 생성 및 주행 테스트")
	void carStayTest() {

		RacingCar car = new RacingCar();

		// 람다식으로 자동차 상태값으로 움직임을 제어로 변경
		car.move(() -> true);

		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 단일 객체 생성 및 주행 테스트")
	void carMoveTest() {
		RacingCar car = new RacingCar();

		// 람다식으로 자동차 상태값으로 움직임을 제어로 변경
		car.move(() -> false);

		assertThat(car.getDistance()).isZero();
	}
}

package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.model.RacingCar;

class RacingCarTest {


	@Test
	@DisplayName("자동차 랜덤 레이스 움직임 구현")
	void randomRaceCarTest() {

		RacingCar car = new RacingCar();

		car.move(() -> car.axel().isMove());

		assertThat(car.getDistance()).isPositive();
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

	@Test
	@DisplayName("랜덤 상수 생성 테스트")
	void randomTest() {

		int number = new Random().nextInt(10);

		System.out.println(number);
		assertThat(number).isLessThan(10);
	}
}

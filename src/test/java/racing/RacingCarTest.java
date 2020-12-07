package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.model.RacingCar;
import racing.model.RacingCars;

public class RacingCarTest {

	@Test
	@DisplayName("자동차 여러대 객체 생성 및 주행 테스트")
	void createCarsRacingTest() {

		RacingCars cars = new RacingCars(5);

		cars.start(3);
	}

	@Test
	@DisplayName("랜덤 상수 생성 테스트")
	void randomTest() {

		int number = new Random().nextInt(10);

		System.out.println(number);
		assertThat(number).isLessThan(10);
	}

	@Test
	@DisplayName("자동차 단일 객체 생성 및 주행 테스트")
	void createCarObjectTest() {

		RacingCar car = new RacingCar();

		for (int i = 0; i < 10; i++) {
			car.racing();
			System.out.println(car.getDistance());
		}

		assertThat(car.getDistance()).isLessThan(10);
	}
}

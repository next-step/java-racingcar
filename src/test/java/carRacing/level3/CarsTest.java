package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.domain.Car;
import carRacing.level3.domain.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private static final Integer TOTAL_CAR_NUM = 2;

	@Test
	@DisplayName("자동차 수를 받아 자동차 객체를 생성한다.")
	void 자동차_준비_테스트() {

		Cars cars = new Cars(List.of(new Car(), new Car()));
		cars.prepare(TOTAL_CAR_NUM);
		assertThat(cars).isNotNull();

	}
}


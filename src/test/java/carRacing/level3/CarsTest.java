package carRacing.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import carRacing.level3.domain.Car;
import carRacing.level3.domain.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private static final Integer TEST_CARSUM = 2;
	private static final Integer TEST_CARNUM = 1;
	private static final Integer DEFAULT_LOCATION = 1;

	@Test
	@DisplayName("자동차들의 리스트를 만들어서 모두 Car객체를 만들어준다.")
	void 자동차_준비_테스트() {

		Cars cars = new Cars(List.of(new Car(), new Car()));
		cars.prepare(TEST_CARSUM);

		for (int i = 0; i < TEST_CARSUM; i++) {
			assertEquals(cars.carLocation(i), 1);
		}

	}

	@Test
	@DisplayName("처음 라운드는 모두 한칸씩 이동하여 현재 이동 상태는 2이다")
	void setInitTest() {
		Cars cars = new Cars(List.of(new Car(), new Car()));
		cars.moveCarLocation(TEST_CARNUM);
		assertEquals(cars.carLocation(TEST_CARNUM),DEFAULT_LOCATION+1);
	}

}


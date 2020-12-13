package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("Cars의 Car 리스트는 수정할 수 없다.")
	void unmodifiableListTest() {
		List<Car> cars = new Cars(new CarNumber(3).createCars()).getCars();

		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> cars.add(new Car()));
	}

	@Test
	@DisplayName("항상 전진하는 Cars를 생성하고 모든 Car가 전진하는지 확인한다.")
	void goOrStopTest() {
		Cars cars = new Cars(new CarNumber(3).createCars()) {
			@Override
			public int getNumber() {
				return 4;
			}
		};

		cars.goOrStop();

		assertThat(cars.getCars())
			.containsExactly(new Car(1), new Car(1), new Car(1));
	}
}

package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
	@Test
	@DisplayName("carNumber만큼 car를 생성한다.")
	void constructorTest() {
		Cars cars = new Cars(3, DefaultNumberGenerator.getMustGoGenerator());

		assertThat(cars).isNotNull();
		assertThat(cars.get(0)).isNotNull();
		assertThat(cars.get(1)).isNotNull();
		assertThat(cars.get(2)).isNotNull();
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> cars.get(3));
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 5, 9})
	@DisplayName("carNumber만큼 car를 생성한다.")
	void goOrStopTest(int tryNumber) {
		Cars cars = new Cars(3, DefaultNumberGenerator.getMustGoGenerator());

		for (int i = 0; i < tryNumber; i++) {
			cars.goOrStop();
		}

		assertThat(cars.get(0).getPosition()).isEqualTo(tryNumber);
		assertThat(cars.get(1).getPosition()).isEqualTo(tryNumber);
		assertThat(cars.get(2).getPosition()).isEqualTo(tryNumber);
	}

	@Test
	@DisplayName("깊은 복제로 새로운 Car 객체를 생성하고 리스트를 반환한다.")
	void cloneListTest() {
		Cars cars = new Cars(3, DefaultNumberGenerator.getMustGoGenerator());
		List<Car> cloneCars = cars.cloneList();

		assertThat(cars.get(0)).isNotEqualTo(cloneCars.get(0));
		assertThat(cars.get(1)).isNotEqualTo(cloneCars.get(1));
		assertThat(cars.get(2)).isNotEqualTo(cloneCars.get(2));
	}
}

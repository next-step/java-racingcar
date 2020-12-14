package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private Names names;

	@BeforeEach
	void setUp() {
		names = new Names("test1,test2,test3");
	}

	@Test
	@DisplayName("Cars의 Car 리스트는 수정할 수 없다.")
	void unmodifiableListTest() {
		List<Car> cars = new Cars(names).getCars();

		assertThatExceptionOfType(UnsupportedOperationException.class)
			.isThrownBy(() -> cars.add(new Car("test")));
	}

	@Test
	@DisplayName("항상 전진하는 Cars를 생성하고 모든 Car가 전진하는지 확인한다.")
	void goOrStopTest() {
		Cars cars = new Cars(names);

		cars.goOrStop(() -> 4);

		assertThat(cars.getCars())
			.containsExactly(new Car("test1", 1), new Car("test2", 1), new Car("test3", 1));
	}

	@Test
	@DisplayName("입력된 carNumber만큰 Car 리스트를 생성한다.")
	void createCarsTest() {
		assertThat(Cars.createCars(names)).hasSize(3);
	}

	@Test
	@DisplayName("우승한 자동차 List를 반환한다.")
	void findWinner() {
		Cars cars = new Cars(Arrays.asList(
			new Car("test1", 2),
			new Car("test2", 3),
			new Car("test3", 5),
			new Car("test4", 3),
			new Car("test5", 5)
		));

		assertThat(cars.findWinners()).contains(new Car("test3", 5), new Car("test5", 5));
	}
}

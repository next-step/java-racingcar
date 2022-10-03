package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

	@DisplayName("자동차 이름의 개수만큼 자동차가 생성된다.")
	@Test
	void generateCars() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Cars cars = new Cars(names);
		Assertions.assertThat(cars.getCars()).hasSize(2);
	}

	@DisplayName("자동차 생성 시 이름 목록이 null이면 에러를 반환한다.")
	@Test
	void validateNameIsNull() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Cars(null);
			});
	}

	@DisplayName("우승자 한명")
	@Test
	void winner() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Cars cars = new Cars(names);
		List<Car> carList = cars.getCars();
		Car a = carList.get(0);
		Car b = carList.get(1);

		a.move(true);

		Assertions.assertThat(cars.getWinners()).containsExactly(a);
	}

	@DisplayName("우승자 여러명")
	@Test
	void winners() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Cars cars = new Cars(names);
		List<Car> carList = cars.getCars();
		Car a = carList.get(0);
		Car b = carList.get(1);

		a.move(true);
		b.move(true);

		Assertions.assertThat(cars.getWinners()).containsExactly(a, b);
	}
}

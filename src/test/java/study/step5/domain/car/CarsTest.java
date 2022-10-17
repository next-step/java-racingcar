package study.step5.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.movestrategy.MoveStrategy;

class CarsTest {

	@DisplayName("이름 개수와 만들어진 car의 개수는 같다.")
	@Test
	void Given_Names_Then_ReturnCars() {
		List<String> names = List.of(new String[] {"a", "b", "c"});
		Cars cars = new Cars().createByNames(names);

		assertThat(names.size()).isEqualTo(cars.size());
	}

	@Test
	void findMaxPosition() {
	}

	@DisplayName("위치에 해당하는 자동차를 반환한다.")
	@Test
	void Given_Cars_Then_ReturnCarsByPosition() {
		Cars cars = new Cars(Arrays.asList(new Car("car1"), new Car("car2")));
		Cars result = cars.getAllByPosition(0);

		assertThat(result.size()).isEqualTo(cars.size());
	}

	@DisplayName("위치의 최대값을 반환한다.")
	@Test
	void Given_Cars_Then_ReturnMaxPosition() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Cars cars = new Cars(Arrays.asList(car1, car2));

		MoveStrategy moveStrategy = () -> true;
		car1.move(moveStrategy);

		int result = cars.findMaxPosition();
		assertThat(result).isEqualTo(1);
	}
}
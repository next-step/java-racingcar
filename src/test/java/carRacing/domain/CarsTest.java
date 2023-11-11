package carRacing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.strategy.MoveStrategy;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@DisplayName("입력받은 이름들에 맞게 카 리스트를 만들 수 있다")
	@Test
	void makeCarList() {
		List<String> carNames = Arrays.asList("pobi", "lee", "geun");
		Cars cars = new Cars(carNames);

		assertThat(cars.getCars())
				.containsExactly(new Car("pobi"), new Car("lee"), new Car("geun"));
	}

	@DisplayName("랜덤값이 4이상 일 때 카 리스트들의 차를 움직인다")
	@Test
	void moveCarList() {
		List<String> carNames = Arrays.asList("pobi", "lee", "geun");
		Cars cars = new Cars(carNames);
		MoveStrategy moveStrategy = () -> true;
		cars.moveCars(moveStrategy);

		assertThat(cars.getCars())
				.containsExactly(new Car(1, "pobi"), new Car(1, "lee"), new Car(1, "geun"));
	}

	@DisplayName("랜덤값이 4미안 일 때 모든 차는 정지한다")
	@Test
	void stopCarList() {
		List<String> carNames = Arrays.asList("pobi", "lee", "geun");
		Cars cars = new Cars(carNames);
		MoveStrategy moveStrategy = () -> false;
		cars.moveCars(moveStrategy);

		assertThat(cars.getCars())
				.containsExactly(new Car(0, "pobi"), new Car(0, "lee"), new Car(0, "geun"));
	}
}
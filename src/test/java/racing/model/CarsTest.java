package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarsTest {

	@DisplayName("자동차 이름의 개수만큼 자동차가 생성된다.")
	@Test
	void generateCars() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Cars cars = new Cars(names);
		Assertions.assertThat(cars.getCars()).hasSize(2);
	}
}

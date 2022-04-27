package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinnersTest {

	@Test
	void 우승자_목록을_가져온다() {
		Car pobi = new Car("pobi", "---");
		Car gabi = new Car("gabi", "-");
		Car paul = new Car("paul", "----");
		Car jin = new Car("jin", "----");

		List<Car> carList = new ArrayList<>();
		carList.add(pobi);
		carList.add(gabi);
		carList.add(paul);
		carList.add(jin);

		Cars cars = new Cars(carList);

		assertThat(Winners.list(cars)).containsExactly(paul, jin);
	}
}

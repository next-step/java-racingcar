package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void setUp(){
		//given
		Car pobi = new Car("pobi", 10);
		Car juuu = new Car("juuu", 10);
		Car alex = new Car("alex", 8);

		cars = Cars.fromCars(Arrays.asList(pobi, juuu, alex));
	}

	@Test
	@DisplayName("가장 멀리간 위치 구하기")
	void findMaxPosition() {
		//when
		int maxPosition = cars.maxPosition();

		//then
		assertThat(maxPosition).isEqualTo(10);
	}

	@Test
	@DisplayName("우승자 구하기")
	void findWinner() {
		//when
		List<Name> winner = cars.findWinner();

		//then
		assertThat(winner).containsOnly(new Name("pobi"), new Name("juuu"));
	}

	@Test
	@DisplayName("경주 시작")
	void goRace() {
		//when
		cars.racingCars(() -> true);

		//then
		assertThat(cars.maxPosition()).isEqualTo(11);
	}
}
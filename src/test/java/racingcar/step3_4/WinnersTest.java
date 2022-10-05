package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

	private List<Car> cars;

	@BeforeEach
	void setUp() {
		cars = List.of(new Car(new Name("pobi")), new Car(new Name("honux")), new Car(new Name("crong")));
	}

	@DisplayName("우승자(들) 이름 반환")
	@Test
	void getWinnersNameTest() {
		Winners winners = new Winners(cars);

		List<Name> result = winners.getNames();

		assertThat(result).hasSize(3);
		assertThat(result).contains(new Name("pobi"), new Name("honux"), new Name("crong"));
	}
}

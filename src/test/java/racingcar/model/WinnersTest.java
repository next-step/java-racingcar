package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
	@DisplayName("우승자 찾기")
	@Test
	void 우승자_찾기() {
		Car pobi = new Car("pobi");
		Car conan = new Car("conan");
		List<Car> cars = Arrays.asList(pobi, conan);
		List<Car> winners = Winners.findWinners(cars);
		
		pobi.move(4);
		conan.move(1);

		assertThat(winners).contains(pobi);
	}
}

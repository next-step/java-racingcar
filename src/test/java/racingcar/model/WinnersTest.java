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
		Car pobi = new Car("conan");
		pobi.move(4);
		Car conan = new Car("conan");
		conan.move(1);
		List<Car> carList = Arrays.asList(pobi, conan);
		Cars cars = new Cars(carList);
		Winners winners = new Winners();
		winners.findWinners(cars);
		assertThat(winners.winners().contains(pobi)).isTrue();
	}
}

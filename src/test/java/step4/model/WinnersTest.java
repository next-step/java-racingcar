package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

	Cars cars;
	Winners winners;

	@BeforeEach
	void beforeEach() {
		cars = new Cars(Arrays.asList(
				new Car("hi", 2),
				new Car("hy", 2),
				new Car("hu", 0),
				new Car("ho", 1)
		));
		winners = new Winners();
	}

	@Test
	@DisplayName("우승자의 기준을 잘 가져오는지에 대한 확인")
	void getWinnerStandardTest() {
		assertThat(winners.getWinnerStandard(cars)).isEqualTo(2);
	}

	@Test
	@DisplayName("우승자 목록을 예상대로 잘 가져오는지에 대한 확인")
	void getWinnerTest() {
		assertThat(winners.getWinners(cars)).isEqualTo("hi, hy");
	}
}

package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@Test
	@DisplayName("nextInt(10)의 값은 0이상 9이하이다")
	void nextInt() {
		assertThat(RacingGame.random())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(9);
	}

	@ParameterizedTest
	@DisplayName("자동차는 random값이 4미만일 때 가만히 있고 4이상일 때 전진한다")
	@CsvSource({"0,-", "1,-", "2,-", "3,-", "4,--", "5,--", "6,--", "7,--", "8,--", "9,--"})
	void dont_move(Integer random, String expected) {
		assertThat(RacingGame.move("-", random)).isEqualTo(expected);
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진을 시도할 때 필요한 random ArrayList를 만든다")
	void make_random_list() {
		int cars = 3;

		List<Integer> randomList = RacingGame.makeRandomList(cars);

		for (int i = 0; i < cars; i++) {
			assertThat(randomList.get(i)).isGreaterThanOrEqualTo(0)
					.isLessThanOrEqualTo(9);
		}
	}

	@Test
	@DisplayName("자동차의 초기 상태는 모두 \"-\" 이다")
	void init() {
		int cars = 3;
		Map<String, String> carMap = RacingGame.init(cars);

		for (String car : carMap.values()) {
			assertThat(car).isEqualTo("-");
		}
	}

	@Test
	@DisplayName("3대의 자동차가 한번에 모두 전진한다")
	void move_all_cars() {
		int cars = 3;
		Map<String, String> carList = RacingGame.init(cars);
		List<Integer> randomList = new ArrayList<>();
		for (int i = 0; i < cars; i++) {
			carList.put(Integer.toString(i), "-");
			randomList.add(5);
		}


		RacingGame.moveAll(carList, cars, randomList);

		for (int i = 0; i < cars; i++) {
			assertThat(carList.get(Integer.toString(i))).isEqualTo("--");
		}
	}

}

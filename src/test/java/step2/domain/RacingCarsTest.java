package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class RacingCarsTest {

	@Test
	void 모든_자동차가_한_칸도_움직이지_않았으면_빈_리스트를_반환한다() {
		// given
		RacingCars racingCars = new RacingCars(Arrays.asList(new Car("car1", 0), new Car("car2", 0)));

		// when
		List<String> winnerNames = racingCars.findWinnerNames();

		// then
		assertThat(winnerNames).isEmpty();
	}

	@Test
	void 가장_앞선_자동차가_있다면_이름을_반환한다() {
		// given
		RacingCars racingCars = new RacingCars(Arrays.asList(new Car("car1", 2),
				new Car("car2", 3)));

		// when
		List<String> winnerNames = racingCars.findWinnerNames();

		// then
		assertThat(winnerNames).isEqualTo(Collections.singletonList("car2"));
	}

	@Test
	void 여러_자동차가_동시에_선두라면_공동_1등인_모든_자동차_이름을_반환한다() {
		// given
		RacingCars racingCars = new RacingCars(Arrays.asList(new Car("car1", 2),
				new Car("car2", 3), new Car("car3", 3)));

		// when
		List<String> winnerNames = racingCars.findWinnerNames();

		// then
		assertThat(winnerNames).isEqualTo(Arrays.asList("car2", "car3"));
	}

}

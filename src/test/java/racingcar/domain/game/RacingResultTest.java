package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;

public class RacingResultTest {

	@Test
	void 자동차들의_이름과_위치를_기억한다() {
		Car pobi = new Car("pobi", 3);
		Car crong = new Car("crong", 2);

		RacingResult result = new RacingResult(List.of(pobi, crong));

		List<CarResult> carResults = result.getCarResults();
		assertThat(carResults.get(0).getName()).isEqualTo("pobi");
		assertThat(carResults.get(0).getPosition()).isEqualTo(3);
	}

	@Test
	void 기록한_뒤_자동차가_움직여도_결과는_바뀌지_않는다() {
		Car pobi = new Car("pobi", 3);
		RacingResult result = new RacingResult(List.of(pobi));

		pobi.go(9);

		assertThat(result.getCarResults().get(0).getPosition()).isEqualTo(3);
	}

	@Test
	void 가장_먼_위치의_자동차가_우승한다() {
		RacingResult result = new RacingResult(List.of(new Car("pobi", 3), new Car("crong", 2)));
		assertThat(result.findWinners()).containsExactly("pobi");
	}

	@Test
	void 가장_먼_위치의_자동차가_여러대면_공동우승한다() {
		RacingResult result = new RacingResult(List.of(new Car("pobi", 3), new Car("crong", 3),
			new Car("honux", 2)));
		assertThat(result.findWinners()).containsExactly("pobi", "crong");
	}
}

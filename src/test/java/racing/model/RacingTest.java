package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.RacingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RacingTest {

	@DisplayName("자동차 이름의 개수만큼 자동차가 생성된다.")
	@Test
	void generateCars() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Racing racing = new Racing(names);
		Cars cars = racing.getCars();
		Assertions.assertThat(cars.getCars()).hasSize(2);
	}

	@DisplayName("모든 자동차는 경기가 끝났을 때 한칸 전진한다.")
	@Test
	void raceByMovableTrue() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Racing racing = new Racing(names);
		MoveStrategy moveStrategy = new MoveStrategy(() -> 4);

		List<RacingResult> race = racing.race(moveStrategy);

		Assertions.assertThat(race.get(0).getPosition()).isEqualTo(1);
		Assertions.assertThat(race.get(1).getPosition()).isEqualTo(1);
	}

	@DisplayName("모든 자동차는 경기가 끝났을 때 전진하지 않는다.")
	@Test
	void raceByMovableFalse() {
		List<Name> names = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		Racing racing = new Racing(names);
		MoveStrategy moveStrategy = new MoveStrategy(() -> 3);

		List<RacingResult> race = racing.race(moveStrategy);

		Assertions.assertThat(race.get(0).getPosition()).isEqualTo(0);
		Assertions.assertThat(race.get(1).getPosition()).isEqualTo(0);
	}
}

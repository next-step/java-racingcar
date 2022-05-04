package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

	@DisplayName("자동차의 전진 상태에 따른 순위 (1등 1명)")
	@Test
	public void rankOneWinnerTest() {
		Winners winners = new Winners(List.of(
			new Car(CarName.of("zieun"), MoveCount.of(5)),
			new Car(CarName.of("kyu"), MoveCount.of(4)),
			new Car(CarName.of("cheol"), MoveCount.of(3))
		));

		assertThat(winners.contains(new Car(CarName.of("zieun")))).isTrue();
		assertThat(winners.contains(new Car(CarName.of("kyu")))).isFalse();
		assertThat(winners.contains(new Car(CarName.of("cheol")))).isFalse();
	}


	@DisplayName("1등이 2명 이상인 경우")
	@Test
	public void rankMultiWinnersTest() {
		Winners winners = new Winners(List.of(
			new Car(CarName.of("zieun"), MoveCount.of(5)),
			new Car(CarName.of("kyu"), MoveCount.of(5)),
			new Car(CarName.of("cheol"), MoveCount.of(3))
		));

		assertThat(winners.contains(new Car(CarName.of("zieun")))).isTrue();
		assertThat(winners.contains(new Car(CarName.of("kyu")))).isTrue();
		assertThat(winners.contains(new Car(CarName.of("cheol")))).isFalse();
	}

}
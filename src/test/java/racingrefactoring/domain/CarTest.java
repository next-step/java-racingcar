package racingrefactoring.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@ParameterizedTest(name = "전진 여부 확인 {index} [{arguments}]")
	@CsvSource(value = {
			"true,true",
			"false,false"
	})
	void can_move_forward(boolean movable, boolean moved) throws Exception {
		//when
		car.moveForward(() -> movable);

		//then
		assertThat(car.isMoved()).isEqualTo(moved);
	}

	@ParameterizedTest(name = "자동차의 우승 상태 {index} [{arguments}]")
	@CsvSource(value = {
			"1,false",
			"2,true"
	})
	@DisplayName("자동차의 우승 상태 확인")
	void isWinner(int maxMoveCount, boolean isWinner) throws Exception {
		//when
		car.moveForward(() -> true);
		car.moveForward(() -> true);

		//then
		assertThat(car.isWinner(maxMoveCount)).isEqualTo(isWinner);

	}

}

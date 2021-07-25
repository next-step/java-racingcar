package racingrefactoring.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@Test
	@DisplayName("자동차의 이름이 제한 길이를 초과하는 경우")
	void wrong_name_car() throws Exception {
		//given
		String longName = "long name";

		//when, then
		assertThatThrownBy(() -> new Car(longName))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");

	}

}

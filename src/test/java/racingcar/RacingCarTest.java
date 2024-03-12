package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RacingCarTest {
	@DisplayName("값이 4 이상일 경우 전진한다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void advancePositionFourOver(int number) {
		//given
		Car car = new Car();

		//when
		car.move(number);

		//then
		assertThat(car.getPosition()).isEqualTo(2);
	}

	@DisplayName("값이 4 미만일때는 움직이지 않는다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void noAdvancePositionFourUnder(int number) {
		//given
		Car car = new Car();

		//when
		car.move(number);

		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차 이름을 입력받아 이름이 잘 저장되는지 확인한다.")
	@Test
	void nameToCar () {
		// given
		Car car = Car.createCar("audi");

		// when
		String carName = car.getName();

		// then
		assertThat(carName).isEqualTo("audi");
	}

	@DisplayName("자동차 이름이 5글자가 초과될 경우 예외를 던진다.")
	@Test
	void nameToCarOverFiveNumberOfCharacters () {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Car.createCar("mercedes");
				}).withMessageMatching("글자수가 5를 초과했습니다. 다시 입력해주세요.");
	}
}

package racingcar;

import domain.Car;
import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
	@DisplayName("값이 4 이상일 경우 전진한다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void advancePositionFourOver(int number) {
		//given
		Car car = Car.createCar(new Name("audi"));
		//when
		car.move(number);

		//then
		assertThat(car.getPositionNumber()).isEqualTo(2);
	}

	@DisplayName("값이 4 미만일때는 움직이지 않는다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void noAdvancePositionFourUnder(int number) {
		//given
		Car car = Car.createCar(new Name("audi"));

		//when
		car.move(number);

		//then
		assertThat(car.getPositionNumber()).isEqualTo(1);
	}
}

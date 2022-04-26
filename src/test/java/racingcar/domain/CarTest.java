package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.OutOfRangeException;

public class CarTest {

	@DisplayName("랜덤값 4미만으로 실행시 이동X")
	@ValueSource(ints = {0,3})
	@ParameterizedTest
	public void When_lessThan4_Expected_0(int enginePower) {
		// given
		Car car = new Car(new CarName("poby"));
		EngineStrategy engineStrategy = () -> enginePower;

		// when
		car.run(engineStrategy.generate());

		// then
		assertThat(car.isSamePosition(MoveCount.of(0))).isTrue();
	}

	@DisplayName("랜덤값 4이상으로 실행시 1 이동")
	@ValueSource(ints = {4,9})
	@ParameterizedTest
	public void When_moreThanOrEqual4_Expected_1(int enginePower) {
		// given
		Car car = new Car(CarName.of("poby"));
		EngineStrategy engineStrategy = () -> enginePower;

		// when
		car.run(engineStrategy.generate());

		// then
		assertThat(car.isSamePosition(MoveCount.of(1))).isTrue();
	}

	@DisplayName("랜덤이 범위를 벗어나면 RunTimeException발생")
	@ValueSource(ints = {-1,10})
	@ParameterizedTest
	public void When_RandomNumberIsOutOfRange_Expected_RunTimeException(int enginePower) {
		// given
		Car car = new Car(CarName.of("poby"));
		EngineStrategy engineStrategy = () -> enginePower;

		// when, then
		assertThatThrownBy(() -> car.run(engineStrategy.generate()))
			.isInstanceOf(OutOfRangeException.class);
	}

	@DisplayName("이름 기준 동일한 차인지 확인")
	@Test
	public void When_givenSameName_Expected_SameCar() {
		Car targetCar = new Car(CarName.of("zieun"), MoveCount.of(5));
		Car compareCar = new Car(CarName.of("zieun"), MoveCount.of(3));

		assertThat(targetCar.equals(compareCar)).isTrue();
	}
}

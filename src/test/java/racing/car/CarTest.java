package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "9999999,9999999"})
	@DisplayName("Car.moveForward() 메소드로 Car.position 이 증가했는지 확인")
	void moveForward(int moveCount, int expectedPosition) {
		// given
		Car car = new Car(value -> {
			throw new UnsupportedOperationException();
		}, () -> {
			throw new UnsupportedOperationException();
		});

		// when
		IntStream.range(0, moveCount).forEach(value -> car.moveForward());

		// then
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0,true", "1,2,true", "9,8,false"})
	@DisplayName("Car.getChanceForMoveForward() 호출시 moveCondition, moveChanceGenerator 에 따라 전진하는지 테스트")
	void getChanceForMoveForward(int condition, int chance, boolean isMoved) {
		// given
		IntPredicate moveCondition = value -> value >= condition;
		MoveChanceGenerator fixedChanceGenerator = () -> chance;
		Car car = new Car(moveCondition, fixedChanceGenerator);

		// when
		final int beforePosition = car.getPosition();
		car.getMoveForwardChance();
		final int afterPosition = car.getPosition();

		// then
		assertThat(beforePosition + 1 == afterPosition).isEqualTo(isMoved);
	}
}

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
		Car car = new Car(createEmptyMoveForwardStrategy());

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
		MoveForwardStrategy moveForwardStrategy = createMoveForwardStrategy(condition, chance);
		Car car = new Car(moveForwardStrategy);

		// when
		final int beforePosition = car.getPosition();
		car.getMoveForwardChance();
		final int afterPosition = car.getPosition();

		// then
		assertThat(beforePosition + 1 == afterPosition).isEqualTo(isMoved);
	}

	private MoveForwardStrategy createEmptyMoveForwardStrategy() {
		return new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				throw new UnsupportedOperationException();
			}
		};
	}

	private MoveForwardStrategy createMoveForwardStrategy(int condition, int chance) {
		return new MoveForwardStrategy() {
			@Override
			public int createMoveForwardChance() {
				return chance;
			}

			@Override
			public boolean isSatisfiedToMoveForward(int chance) {
				return chance >= condition;
			}
		};
	}
}

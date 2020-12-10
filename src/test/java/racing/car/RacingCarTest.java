package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "9999999,9999999"})
	@DisplayName("RacingCar.moveForward() 메소드로 RacingCar.position 이 증가했는지 확인")
	void moveForward(int moveCount, int expectedPosition) {
		// given
		RacingCar racingCar = new RacingCar("", () -> {
			throw new UnsupportedOperationException();
		});

		// when
		IntStream.range(0, moveCount).forEach(value -> racingCar.moveForward());

		// then
		assertThat(racingCar.getPosition()).isEqualTo(expectedPosition);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0,true", "1,2,true", "9,8,false"})
	@DisplayName("RacingCar.getChanceForMoveForward() 호출시 moveCondition, moveChanceGenerator 에 따라 전진하는지 테스트")
	void getChanceForMoveForward(int condition, int chance, boolean isMoved) {
		// given
		MoveChanceGenerator moveChanceGenerator = () -> condition <= chance;
		RacingCar racingCar = new RacingCar("", moveChanceGenerator);

		// when
		final int beforePosition = racingCar.getPosition();
		racingCar.getMoveForwardChance();
		final int afterPosition = racingCar.getPosition();

		// then
		assertThat(beforePosition + 1 == afterPosition).isEqualTo(isMoved);
	}

	@ParameterizedTest
	@CsvSource(value = {"hi,2", "peter,0"})
	@DisplayName("RacingCar.toString() 테스트")
	void racingCarToString(String name, int position) {
		// given
		RacingCar racingCar = new RacingCar(name, () -> true, position);

		// when
		String toString = racingCar.toString(rc ->
				String.format("%s %s", racingCar.getCarName(), racingCar.getPosition()));

		// then
		assertThat(toString).isEqualTo(String.format("%s %s", name, position));
	}
}

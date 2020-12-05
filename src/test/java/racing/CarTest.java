package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "9999999,9999999"})
	@DisplayName("Car.moveForward() 메소드로 Car.position 이 증가했는지 확인")
	void moveForward(int moveCount, int expectedPosition) {
		// given
		Car car = new Car();

		// when
		IntStream.range(0, moveCount).forEach(value -> car.moveForward());

		// then
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}
}

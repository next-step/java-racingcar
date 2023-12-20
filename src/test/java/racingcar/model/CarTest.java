package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	@DisplayName("자동차가 정지한다")
	@Test
	void 자동차가_정지한다() {
		Distance distance = new Distance();
		Car car = new Car("pobi", distance);
		assertThat(car.distance()).isEqualTo(distance);
	}

	@ParameterizedTest
	@DisplayName("random한 수가 4 이상이면 전진한다.")
	@CsvSource(value = { "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1" }, delimiter = ':')
	void 자동차가_전진한다(int randomNumber, int expecting) {
		Car car = new Car("0");
		Distance expectingResult = new Distance(expecting);
		car.move(randomNumber);
		assertThat(car.distance()).isEqualTo(expectingResult);
	}
}

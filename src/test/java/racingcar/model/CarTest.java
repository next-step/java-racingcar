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

	@DisplayName("자동차가 전진한다")
	@Test
	void 자동차가_전진한다() {
		Car car = new Car("pobi");
		car.move(4);
		Distance distance = new Distance(1);
		assertThat(car.distance()).isEqualTo(distance);
	}

	@DisplayName("위치값 일치여부")
	@Test
	void 위치값_일치여부() {
		Distance pobiDistance = new Distance(3);
		Car car = new Car("pobi", pobiDistance);
		Distance distance = new Distance(3);
		assertThat(car.distance()).isEqualTo(distance);
	}
}

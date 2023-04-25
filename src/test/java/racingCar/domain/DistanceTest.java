package racingCar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DistanceTest {

	@ParameterizedTest(name = "거리 {arguments} 인 Distance VO 간의 동등성 비교")
	@ValueSource(ints = { 0, 1, 2 })
	void is_equal(int amount) {
		Distance given = Distance.from(amount);

		Distance expectedEqual = Distance.from(amount);
		Distance expectedNotEqual = Distance.from(amount + 1);

		assertAll(
			() -> assertThat(given).isEqualTo(expectedEqual),
			() -> assertThat(given).hasSameHashCodeAs(expectedEqual),

			() -> assertThat(given).isNotEqualTo(expectedNotEqual),
			() -> assertThat(given.hashCode()).isNotEqualTo(expectedNotEqual.hashCode())
		);
	}
}

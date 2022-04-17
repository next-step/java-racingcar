package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

	@DisplayName("원하는 사이즈만큼 Cars가 생성되는지 확인")
	@ValueSource(ints = {3, 10, 100, 300})
	@ParameterizedTest
	public void when_giveCarsSize_expected_CreatedSameSize(int size) {
		// given
		Cars cars = Cars.of(size);

		// when
		int carsSize = cars.size();

		// then
		assertThat(carsSize).isEqualTo(size);
	}
}
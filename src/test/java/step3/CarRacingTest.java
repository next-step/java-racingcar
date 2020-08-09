package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

	@DisplayName(value = "경주에 참여할 자동차 생성 완료 여부 테스트")
	@Test
	void getNewCars() {
		assertThat(CarRacing.getNewCars(4)).allMatch(Objects::nonNull);
	}

}
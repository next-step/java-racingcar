package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.CarInfo;
import racingcar.domain.Cars;

class CarsTest {

	@ParameterizedTest
	@MethodSource("carsName")
	@DisplayName("모든 자동차의 초기 위치는 0이다.")
	void initialCarAmountTest(List<String> names, int carAmount) {
		// when
		Cars cars = new Cars(names);

		// then
		List<CarInfo> carInfos = cars.getCarsNameAndLocation();
		assertThat(carInfos.size()).isEqualTo(carAmount);
		for (int i = 0; i < names.size(); i++) {
			assertThat(carInfos.get(i)
				.name()).isEqualTo(names.get(i));
			assertThat(carInfos.get(i)
				.location()).isZero();
		}
	}

	@Test
	@DisplayName("입력한 자동차들의 이름에 중복이 존재하면 예외를 반환한다.")
	void nameDuplicateTest() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				new Cars(List.of("a", "a", "b"));
			})
			.withMessageContaining("중복된 자동차 이름이 존재합니다.");
	}

	static Stream<Arguments> carsName() {
		return Stream.of(
			Arguments.of(List.of("pobi", "crong", "honux"), 3),
			Arguments.of(List.of("aaa", "bbbb"), 2)
		);
	}

}

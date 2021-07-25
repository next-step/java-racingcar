package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.model.RacingCars;

class RacingCarsTest {
	RacingCars racingCars;

	@BeforeEach
	void setUp() {
		racingCars = new RacingCars(3);
	}


	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 4 })
	void 생성자를_호출하였을_때_초기값_0으로_위치값이_세팅된다(int carNum) {
		racingCars = new RacingCars(carNum);
		racingCars.getCars().stream().forEach(racingCar -> {
			assertThat(racingCar.getRacingCarDashString()).isEqualTo("");
		});
	}

	@Test
	void 모든_자동차들의_전진함수가_호출된다면_모든_자동차들은_한_칸씩_전진한다() {
		racingCars.getCars().stream()
			.filter(racingCar -> true)				// 무조건 전진한다고 가정
			.forEach(racingCar -> {
				racingCar.forward();
			});

		for (int i = 0 ; i < 3 ; i++) {
			assertThat(racingCars.getCars().get(i)).isEqualTo("-");
		}
	}
}

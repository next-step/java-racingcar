package step3.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.racingcar.domain.RacingCar;
import step3.racingcar.domain.RacingCarGenerator;
import step3.racingcar.domain.RacingCars;

public class RacingCarTest {

	@DisplayName("4 이상의 정수 값일 경우 자동차 움직임")
	@Test
	void given_integer_greater_or_equal_four_when_car_move_then_move_distance_increase() {
		RacingCar car = new RacingCar("pobi");
		car.move(4);
		car.move(5);
		assertThat(car.getMoveDistance()).isEqualTo(2);
	}

	@DisplayName("4 이상의 정수가 아닌 경우 자동차 움직이지 않는다")
	@Test
	void given_integer_less_than_four_when_car_move_then_move_distance_dont_change() {
		RacingCar car = new RacingCar("pobi");
		car.move(3);
		car.move(3);
		car.move(1);
		car.move(2);
		assertThat(car.getMoveDistance()).isEqualTo(0);
	}

	@DisplayName("레이싱카 일급 콜렉션 생성")
	@Test
	void given_car_names_when_generate_then_return_racingcars() {
		final String[] racingCarNames = new String[]{"pobi","hong","conan","tayo","lee"};
		final int expectedRacingCarsCount = racingCarNames.length;
		RacingCars racingCars = RacingCarGenerator.generate(racingCarNames);
		assertThat(racingCars.getRacingCars()).hasSize(expectedRacingCarsCount);
	}

	@DisplayName("자동차 콜렉션에서 이름 구하기")
	@Test
	void given_racing_cars_when_get_names_then_return_racingcar_names() {
		RacingCars racingCars = new RacingCars(Stream.of(
			new RacingCar("hong", 5),
			new RacingCar("pobi", 3),
			new RacingCar("lee", 5)
		).collect(Collectors.toList()));

		assertThat(racingCars.getNames()).isEqualTo("hong, pobi, lee");
	}

	@DisplayName("자동차 이름 5자 초과시 익셉션 발생")
	@Test
	void given_car_name_length_greater_than_five_when_new_racingcar_return_exception() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCar("hoonmaro"))
			.withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
	}

}

package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

	@DisplayName("자동차 생성 성공")
	@Test
	public void testCreateCarSuccess() {
		//given
		String name = "부릉이";

		//when
		RacingCar car = new RacingCar(name);

		//then
		Assertions.assertThat(car.getName()).isEqualTo(name);
	}

	@DisplayName("부적합한 이름의 자동차 생성 실패")
	@Test
	public void testCreateLongNameCarFailure() {
		//given
		String longName = "부릉부릉자동차";
		String notGiven = null;
		String noName = "";

		//then
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCar(longName));
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCar(notGiven));
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCar(noName));
	}

	@DisplayName("자동차 이동")
	@Test
	public void testCarMove() {
		//given
		int baseValue = 3;
		int go = 1;
		int stop = 0;

		//when
		RacingCar car = new RacingCar("부릉이");

		//then
		Assertions.assertThat(car.move(baseValue + 1)).isEqualTo(go);
		Assertions.assertThat(car.move(baseValue)).isEqualTo(go + stop);
		Assertions.assertThat(car.move(baseValue + 1)).isEqualTo(go + stop + go);
	}
}

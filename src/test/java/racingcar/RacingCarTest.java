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

	public void testCarMove() {
		//음 이건 뭘 테스트해야하지..?
	}
}

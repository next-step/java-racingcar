package study.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JavaRacingcarSimpleTest {

	final JavaRacingcarSimple javaRacingcarSimple = new JavaRacingcarSimple();

	@DisplayName("random 값이 4 이상인 경우 true 를 반환한다")
	@Test
	void Given_MoreThen4_Then_ReturnTrue() {
		boolean result = javaRacingcarSimple.isGoForward(4);
		assertThat(result).isTrue();
	}

	@DisplayName("random 값이 4 미만인 경우 false 를 반환한다")
	@Test
	void Given_Under4_Then_ReturnFalse() {
		boolean result = javaRacingcarSimple.isGoForward(3);
		assertThat(result).isFalse();
	}

	@DisplayName("initRacingCar 메서드 실행하면 position 값은 0으로 초기화한다.")
	@Test
	void Given_initRacingCar_Then_InitPosition() {
		Racingcar racingcar = javaRacingcarSimple.initRacingCar();

		assertThat(racingcar.getPosition()).isEqualTo(0);
	}

	@DisplayName("Racingcar 의 move 메서드를 실행하면 position 값이 1 증가한다.")
	@Test
	void Given_MoveRacingCar_Then_InitPosition() {
		Racingcar racingcar = new Racingcar();
		racingcar.initPosition();
		int beforePosition = racingcar.getPosition();

		racingcar.move();
		int afterPostion = racingcar.getPosition();
		assertThat(beforePosition + 1).isEqualTo(afterPostion);
	}
}
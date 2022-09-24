package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
	@Test
	@DisplayName("자동차 수 테스트")
	void howManyCars() {
		int actual = Cars.participant("3");
		assertThat(actual).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차 움직임 횟수 테스트")
	void howManyPlayGames() {
		int actual = Cars.move("5");
		assertThat(actual).isEqualTo(5);
	}

	@Test
	@DisplayName("전진하는 조건 0~9 랜덤값 테스트")
	void randomNumber() {
		int actual = Racing.random();
		assertThat(actual).isBetween(0, 9);
	}

	@ParameterizedTest
	@DisplayName("랜덤값 4이상 일 때만 전진 테스트")
	@CsvSource(value = {
		"1:''",
		"4:-",
		"6:-",
		"9:-"
	}, delimiter = ':')
	void whenMoveMoreThan4(int input, String expected) {
		assertThat(Racing.move(input)).isEqualTo(expected);
	}
}

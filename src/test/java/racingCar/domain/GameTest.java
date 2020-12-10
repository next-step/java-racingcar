package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingCar.domain.Game;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {

	@Order(1)
	@DisplayName("1.경주할 자동차 이름을 입력할 수 있다.")
	@Test
	void userEnterCarCarNames() {
		String userInputCarNames = "pobi,crong,honux";
		int matchCount = 1;
		Game game = new Game(userInputCarNames, matchCount);
		assertThat(game.getCarCount()).isEqualTo(3);
	}

	@Order(3)
	@DisplayName("2.사용자는 경주를 시도할 횟수를 입력할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6})
	void userEnterCarMatchCount(int matchCount) {
		String userInputCarNames = "pobi,crong,honux";
		Game game = new Game(userInputCarNames, matchCount);
		assertThat(game.getMatchCount()).isEqualTo(matchCount);
	}

	@Order(4)
	@DisplayName("2.1.경기수는 1보다 작을 수 없다.")
	@Test
	void validateUserEnterMatchCount() {
		String userInputCarNames = "pobi,crong,honux";
		int matchCount = 0;
		assertThatThrownBy(() -> {
			Game game = new Game(userInputCarNames, matchCount);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("경기수는 1보다 작을 수 없습니다.");
	}

}

package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {
	@Order(1)
	@DisplayName("1.사용자는 자동차의 수를 입력할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {4,5,6})
	void userEnterCarCount(int carCount){
		int matchCount = 1;
		Game game = new Game(carCount, matchCount);
		assertThat(game.getCarCount()).isEqualTo(carCount);
	}

	@Order(2)
	@DisplayName("1.1.자동차 수는 1보다 작을 수 없다.")
	@Test
	void validateUserEnterCarCount(){
		int carCount = 0;
		int matchCount = 1;
		assertThatThrownBy(() -> {
			Game game = new Game(carCount, matchCount);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 수는 1보다 작을 수 없습니다.");
	}

	@Order(3)
	@DisplayName("2.사용자는 경주를 시도할 횟수를 입력할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {4,5,6})
	void userEnterCarMatchCount(int matchCount){
		int carCount = 5;
		Game game = new Game(carCount, matchCount);
		assertThat(game.getMatchCount()).isEqualTo(matchCount);
	}

	@Order(4)
	@DisplayName("2.1.경기수는 1보다 작을 수 없다.")
	@Test
	void validateUserEnterMatchCount(){
		int carCount = 3;
		int matchCount = 0;
		assertThatThrownBy(() -> {
			Game game = new Game(carCount, matchCount);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("경기수는 1보다 작을 수 없습니다.");
	}

}

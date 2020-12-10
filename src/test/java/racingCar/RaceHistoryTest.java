package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/08
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RaceHistoryTest {
	@Order(1)
	@DisplayName("1.경주횟수만큼 경주기록이 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6})
	void createRaceHistory(int matchCount) {
		String userInputCarNames = "pobi,crong,honux";
		Game game = new Game(userInputCarNames, matchCount);
		Cars raceCars = game.start();
		RaceHistory raceHistory = raceCars.getHistory();
		assertThat(raceHistory.getCount()).isEqualTo(matchCount);
	}
}

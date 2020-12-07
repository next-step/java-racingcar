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
		Game game = new Game(carCount);
		assertThat(game.getCarCount()).isEqualTo(carCount);
	}
}

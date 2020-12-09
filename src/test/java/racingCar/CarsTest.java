package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarsTest {

	@Order(1)
	@DisplayName("1. 사용자가 입력한 자동차의 수 만큼 자동차가 생성된다.")
	@Test
	void createCar() {
		String userInput = "pobi,crong,honux";
		String[] carNames = userInput.split(",");
		int matchCount = 3;
		Cars cars = new Cars(carNames, matchCount);
		assertThat(cars.getCount()).isEqualTo(carNames.length);
	}

	@Order(2)
	@DisplayName("2. 사용자가 입력한 경주 횟수만큼 경주가 반복된다.")
	@Test
	void repeatRaceCount() {
		String userInput = "pobi,crong,honux";
		String[] carNames = userInput.split(",");
		int matchCount = 3;
		Cars cars = new Cars(carNames, matchCount);
		cars.race();
		assertThat(cars.getLapCount()).isEqualTo(matchCount);
	}

	@Order(3)
	@DisplayName("3. 차들이 경주를 완료하면 랩카운트가 증가한다")
	@Test
	void addLapCount() {
		String userInput = "pobi,crong,honux";
		String[] carNames = userInput.split(",");
		int matchCount = 3;
		Cars cars = new Cars(carNames, matchCount);
		cars.runLap();
		assertThat(cars.getLapCount()).isEqualTo(1);
	}

	@Order(4)
	@DisplayName("4. 차들이 경주를 완료하면 우승자는 한명 이상일 수 있다.")
	@Test
	void racingWinnerExist() {
		String userInput = "pobi,crong,honux";
		String[] carNames = userInput.split(",");
		int matchCount = 3;
		Cars cars = new Cars(carNames, matchCount);
		cars.race();
		assertThat(cars.getWinners().size()).isGreaterThanOrEqualTo(1);
	}
}

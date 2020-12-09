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
public class CarsTest {

	@Order(1)
	@DisplayName("1. 사용자가 입력한 자동차의 수 만큼 자동차가 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4})
	void createCar(int carCount) {
		int matchCount = 3;
		Cars cars = new Cars(carCount, matchCount);
		assertThat(cars.getCount()).isEqualTo(carCount);
	}

	@Order(2)
	@DisplayName("2. 사용자가 입력한 경주 횟수만큼 경주가 반복된다.")
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6})
	void repeatRaceCount(int carCount){
		int matchCount = 3;
		Cars cars = new Cars(carCount, matchCount);
		cars.race();
		assertThat(cars.getLapCount()).isEqualTo(matchCount);
	}

	@Order(3)
	@DisplayName("3. 차들이 경주를 완료하면 랩카운트가 증가한다")
	@Test
	void addLapCount(){
		int matchCount = 3;
		int carCount = 2;
		Cars cars = new Cars(carCount, matchCount);
		cars.runLap();
		assertThat(cars.getLapCount()).isEqualTo(1);
	}
}

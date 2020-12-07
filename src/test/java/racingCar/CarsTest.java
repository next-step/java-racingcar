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
public class CarsTest {

	@Order(1)
	@DisplayName("1. 사용자가 입력한 자동차의 수 만큼 자동차가 생성된다.")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4})
	void moveWhenArgOverFour(int arg) {
		Cars cars = new Cars();
		for(int i=0; i< arg; i++){
			Car car = new Car();
			cars.add(car);
		}
		assertThat(cars.getCount()).isEqualTo(arg);
	}
}

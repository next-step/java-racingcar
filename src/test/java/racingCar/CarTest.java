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
public class CarTest {

	@Order(1)
	@DisplayName("1. 자동차의 전진 조건값이 4이상일 경우 이동한다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6})
	void moveWhenArgOverFour(int arg) {
		Car car = new Car();
		assertThat(car.move(arg)).isEqualTo(1);
	}

	@Order(2)
	@DisplayName("1.1 자동차의 전진 조건값이 4보다 작을 경우 이동하지 않는다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void notMoveWhenArgUnderFour(int arg) {
		Car car = new Car();
		assertThat(car.move(arg)).isEqualTo(0);
	}
}

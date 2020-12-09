package racingCar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author : byungkyu
 * @date : 2020/12/09
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarHistoryTest {
	@Order(1)
	@DisplayName("1. 자동차가 움직인 이력을 저장")
	@Test
	void carHistory() {
		String carName = "pobi";
		Car car = new Car(carName);
		car.randomMove();

		CarHistory carHistory = new CarHistory(car);
		assertThat(carHistory.getName()).isEqualTo(car.getName());
		assertThat(carHistory.getPosition()).isEqualTo(car.getPosition());
	}
}
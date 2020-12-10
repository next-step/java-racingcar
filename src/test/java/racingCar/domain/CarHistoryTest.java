package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import racingCar.domain.Car;
import racingCar.domain.CarHistory;
import racingCar.domain.move.MoveUtil;

/**
 * @author : byungkyu
 * @date : 2020/12/09
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarHistoryTest {
	private MoveUtil moveUtil;

	@BeforeEach
	void setUp() {
		moveUtil = new MoveUtil();
	}

	@Order(1)
	@DisplayName("1. 자동차가 움직인 이력을 저장")
	@Test
	void carHistory() {
		String carName = "pobi";
		Car car = new Car(moveUtil, carName);
		//car.randomMove();

		CarHistory carHistory = new CarHistory(car);
		assertThat(carHistory.getName()).isEqualTo(car.getName());
		assertThat(carHistory.getPosition()).isEqualTo(car.getPosition());
	}
}
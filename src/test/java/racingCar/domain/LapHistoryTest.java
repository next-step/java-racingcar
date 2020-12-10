package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import racingCar.domain.Car;
import racingCar.domain.CarHistory;
import racingCar.domain.LapHistory;
import racingCar.domain.move.MoveUtil;

/**
 * @author : byungkyu
 * @date : 2020/12/09
 * @description :
 **/
public class LapHistoryTest {
	private MoveUtil moveUtil;

	@BeforeEach
	void setUp() {
		moveUtil = new MoveUtil();
	}

	@Order(1)
	@DisplayName("1. Lap 저장구간에 차량의 데이터를 저장한다.")
	@Test
	void storeLapHistory() {
		Car benz = new Car(moveUtil, "benz");
		Car bmw = new Car(moveUtil, "bmw");

		CarHistory benzHistory = new CarHistory(benz);
		CarHistory bmwHistory = new CarHistory(bmw);

		LapHistory lapHistory = new LapHistory();
		lapHistory.add(benzHistory);
		lapHistory.add(bmwHistory);
		assertThat(lapHistory.get()).contains(benzHistory);
		assertThat(lapHistory.get()).contains(bmwHistory);
	}
}

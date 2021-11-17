package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Cars;
import study.racingcar.domain.Position;

public class CarsTest {

	private Cars cars;

	@BeforeEach
	void init(){
		//given
		int carCount = 5;
		cars = new Cars(carCount);
	}

	@Test
	@DisplayName("자동차들 초기 위치값")
	void initCars(){
		//when
		List<Position> positions = cars.positionOfCars();

		//then
		for (Position position : positions) {
			assertThat(position.valueOfPosition()).isEqualTo(0);
		}
	}
}

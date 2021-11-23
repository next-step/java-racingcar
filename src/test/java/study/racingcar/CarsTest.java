package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;

public class CarsTest {

	private Cars cars;

	@BeforeEach
	void init(){
		//given
		List<String> names = Arrays.asList("pobi", "juu", "alex");
		cars = new Cars(names);
	}

	@Test
	@DisplayName("자동차들 초기 위치값")
	void initCars(){
		//when
		List<Car> cars = this.cars.statusOfCars();

		//then
		for (Car car : cars) {
			assertThat(car.carPosition()).isEqualTo(0);
		}
	}
}

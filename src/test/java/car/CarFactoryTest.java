package car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

	@DisplayName("자동차가 알맞게 추가되는지 확인한다.")
	@Test
	void test1() {
		CarFactory carFactory = new CarFactory();
		List<Car> cars = carFactory.createCars();
		carFactory.addCar(cars, "pobi");
		carFactory.addCar(cars, "crong");

		assertThat(cars.get(0).getName()).isEqualTo("pobi");
		assertThat(cars.get(1).getName()).isEqualTo("crong");
	}
}

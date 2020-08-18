package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarFactoryTest {

	@Test
	public void makeCarTestWithString() {
		String carnames = "abc,def";
		List<Car> cars= CarFactory.create(carnames);
		assertThat(cars).contains(new Car("abc"), new Car("def"));
	}

	@Test
	public void makeCarTestWithArray() {
		String[] carname = {"abc","def"};
		List<Car> cars = CarFactory.createCarWithArray(carname);
		assertThat(cars).contains(new Car("abc"), new Car("def"));
	}
}

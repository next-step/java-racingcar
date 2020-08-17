package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarFactoryTest {

	@Test
	public void makeCarTest() {
		String[] Carname = {"abc","def"};
		CarFactory carFactory = new CarFactory(Carname);
		List<Car> cars= carFactory.getCars();
		assertThat(cars).contains(new Car("abc"), new Car("def"));
		
	}
}

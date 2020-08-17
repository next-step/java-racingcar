package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class CarTest {
	
	@Test
	public void compareCar() {
		Car car = new Car("car");
		assertThat(car).isEqualTo(new Car("car"));
		assertThat(car).isNotEqualTo(new Car("car2"));
	}
	
	@Test
	public void compareCar2() {
		Car car = new Car("car");
		car.go(5);
		
		Car car2 = new Car("car");
		car2.go(8);
		
		Car car3 = new Car("car");
		car3.go(3);
		
		assertThat(car).isEqualTo(car2);
		assertThat(car).isNotEqualTo(car3);
	}
	
	@Test
	public void compareCarWithLocation() {
		Car car = new Car("car",6);
		Car car2 = new Car("car", 5);
		car2.go(5);
		assertThat(car).isEqualTo(car2);
		assertThat(car.getLocation()).isEqualTo(6);
		
	}
	
}

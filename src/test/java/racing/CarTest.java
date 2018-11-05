package racing;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	
	@Test
	public void move() throws NoSuchAlgorithmException {
		Car car = new Car("타요");
		car.move();
	}
	
	@Test
	public void canMove_4미만() {
		boolean result = Car.canMove(3);
		assertThat(result).isFalse();
	}
	
	@Test
	public void canMove_4이상() {
		boolean result = Car.canMove(4);
		assertThat(result).isTrue();
	}
}
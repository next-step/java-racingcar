package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.level3.model.Car;
import carRacing.level3.model.CarName;
import carRacing.level3.model.Location;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 최대값_일치(){
		Car car = new Car(new CarName("car1"),new Location(3));
		assertThat(car.isMaxLocation(new Location(3))).isEqualTo(true);
	}

}
